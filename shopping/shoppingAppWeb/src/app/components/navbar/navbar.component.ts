import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { Broadcaster, BroadcastEvent } from 'src/app/broadcast-event.service';
import { ProductService } from 'src/app/product.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  carts: any;
  constructor(private productService: ProductService, private _broadcaster: Broadcaster) {
    this.carts = [];
    this._broadcaster.on<Subject<BroadcastEvent>>()
      .subscribe(result => {
        if (result.key === 'cartItems') {
          this.carts = result.data;
        }
      });
  }

  ngOnInit(): void {
  }
}
