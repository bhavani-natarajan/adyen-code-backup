import { Component, OnInit } from '@angular/core';
import { Broadcaster } from 'src/app/broadcast-event.service';
import { ProductService } from 'src/app/product.service';
import { HttpService } from '../../http.service';
@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
})
export class ProductsComponent implements OnInit {
  products: any;
  addMessage: any;
  constructor(private http: HttpService, private productService: ProductService, private _broadcaster: Broadcaster) { }
  _getProducts(): void {
    this.products = this.productService.getAllProducts();
  }
  _addItemToCart(product: any): void {
    this.productService.addToCart(product);
    this._broadcaster.broadcast('cartItems', this.productService.cartItems);
    product.addMessage = "Added to Cart";
    setTimeout(() => {
      product.addMessage = "";
    }, 700);
  }
  ngOnInit(): void {
    this._getProducts();
  }
}