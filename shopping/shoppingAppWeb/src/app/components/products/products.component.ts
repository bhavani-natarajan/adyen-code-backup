import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/product.service';
import { HttpService } from '../../http.service';
@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
})
export class ProductsComponent implements OnInit {
  products: any;
  constructor(private http: HttpService, private productService: ProductService) {}
  _getProducts(): void {
    this.products = this.productService.getAllProducts();
  }
  _addItemToCart( product: any): void {
    this.productService.addToCart(product);
  }
  ngOnInit(): void {
    this._getProducts();
  }
}