import { Component } from '@angular/core';
import { Broadcaster } from './broadcast-event.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [Broadcaster]
})
export class AppComponent {
  title = 'shoppingApp';
}
