import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/product.service';
import { HttpService } from '../../http.service';
import AdyenCheckout from '@adyen/adyen-web';
import '@adyen/adyen-web/dist/adyen.css';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  carts: any;
  cartDetails: any;
  total: any;
  constructor(private http: HttpService, private productService: ProductService, private router: Router) { }
  _getCart(): void {
    this.carts = this.productService.getCartItems();
    this.total = 0;
    console.log(this.carts);
    for (let cartItem in this.carts) {
      this.total += +this.carts[cartItem].price;
    }
  }

  ngOnInit(): void {
    this._getCart();
  }

  _getPaymentMethods(): void {
    //this.http.getPaymentMethods().toPromise().then((paymentMethodsResponse: any ) => {
    this.http.getPaymentMethods().subscribe(
      data => this.processPayment(data)
    );
  }

  processPayment(paymentMethodsResponse: any) {
    const configuration = {
      paymentMethodsResponse: paymentMethodsResponse, // The `/paymentMethods` response from the server.
      clientKey: "test_7ZCG2HRVQ5DYDG54CTVFVXKYFIKWXTBF", // Web Drop-in versions before 3.10.1 use originKey instead of clientKey.
      locale: "en-US",
      environment: "test",
      onSubmit: (state: any, dropin: any) => {
        this.makePayment(state.data)
          .then((response: any) => {
            if (response.action) {
              // Drop-in handles the action object from the /payments response
              dropin.handleAction(response.action);
            } else {
              // Your function to show the final result to the shopper
              this.showFinalResult(response);
            }
          })
          .catch((error: string | undefined) => {
            throw Error(error);
          });
      },
      onAdditionalDetails: (state: any, dropin: any) => {
        // Your function calling your server to make a `/payments/details` request
        this.makeDetailsCall(state.data)
          .then((response: any) => {
            if (response.action) {
              // Drop-in handles the action object from the /payments response
              dropin.handleAction(response.action);
            } else {
              // Your function to show the final result to the shopper
              this.showFinalResult(response);
            }
          })
          .catch((error: string | undefined) => {
            throw Error(error);
          });
      },
      paymentMethodsConfiguration: {
        card: { // Example optional configuration for Cards
          hasHolderName: true,
          holderNameRequired: true,
          enableStoreDetails: true,
          hideCVC: false, // Change this to true to hide the CVC field for stored cards
          name: 'Credit or debit card',// onSubmit configuration for card payments. Overrides the global configuration.
          billingAddressRequired: true
        }
      }
    };
    //});

    const checkout = new AdyenCheckout(configuration);

    const dropin = checkout
      .create('dropin', {
        openFirstPaymentMethod: false
      })
      .mount('#dropin-container');
  }

  makePayment(stateData: any) {
    const request = { "amount": { "currency": "USD", "value": this.total }, "channel": "Web", "billingAddress": stateData.billingAddress, "shopperEmail": "test.test@tset.com", "shopperIP": "10.0.0.10", "reference": "Bhavani_checkoutChallenge", "paymentMethod": stateData.paymentMethod, "browserInfo": stateData.browserInfo, "origin": "http://localhost:8000", "returnUrl": "http://localhost:8000/checkout", "merchantAccount": "AdyenRecruitmentCOM" };
    return this.http.makePayment(request).toPromise();
  }

  showFinalResult(response: any) {
    if (response.resultCode === "Authorised")
      this.router.navigate(['/success']);
    else if (response.resultCode === "Refused")
      this.router.navigate(['/error']);

  }

  makeDetailsCall(stateData: any) {
    return this.http.paymentDetails("tst").toPromise();
  }
}