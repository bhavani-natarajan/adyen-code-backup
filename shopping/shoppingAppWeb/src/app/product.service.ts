import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: any;
  cartItems: any;
  constructor() {
    this.cartItems = [];
    this.products = [
      {
        _id: 1,
        name: "Toy Story Sheriff Woody Action Figure 16",
        price: "16",
        image: "../../assets/image/prod1.jpg"
      },
      {
        _id: 2,
        name: "Colourful Clown Plush Soft Toy",
        price: "15",
        image: "../../assets/image/prod2.png"
      },
      {
        _id: 3,
        name: "Disney Pixar Toy Story Slinky Figure",
        price: "15",
        image: "../../assets/image/prod3.jfif"
      }
    ]
  }

  getAllProducts() {
    return this.products;
  }

  getCartItems() {
    return this.cartItems;
  }

  addToCart(product: any) {
    this.cartItems.push(product);
  }

  clearCart() {
    this.cartItems = [];
  }
}
