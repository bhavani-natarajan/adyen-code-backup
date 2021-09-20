import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { HttpService } from 'src/app/http.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  queryParams: any;

  constructor(private activatedRoute: ActivatedRoute, private http: HttpService, private router: Router) {
    this.getRouteParams();
  }

  ngOnInit(): void {
  }

  getRouteParams() {
    this.activatedRoute.queryParams.subscribe((params: any) => {
      this.queryParams = params;
      this.makeDetailsCall();
      
    });
}

  makeDetailsCall() {
    const request = {"details":{"redirectResult":this.queryParams.redirectResult}};
    this.http.paymentDetails(request).subscribe(
      response => this.showMessage(response)
    );
  }

  showMessage(response: any){
    if(response.resultCode === "Authorised")
      this.router.navigate(['/success']);
    else
      this.router.navigate(['/error']);
  }
}
