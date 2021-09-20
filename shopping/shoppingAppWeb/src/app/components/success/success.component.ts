import { Component, OnInit } from '@angular/core';
import { Broadcaster } from 'src/app/broadcast-event.service';
import { ProductService } from 'src/app/product.service';

@Component({
  selector: 'app-success',
  templateUrl: './success.component.html',
  styleUrls: ['./success.component.css']
})
export class SuccessComponent implements OnInit {

  constructor(private productService: ProductService, private _broadcaster: Broadcaster) { }

  ngOnInit(): void {
    this.productService.clearCart();
    this._broadcaster.broadcast('cartItems', []);
  }

}
