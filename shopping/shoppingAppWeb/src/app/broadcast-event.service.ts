
import { map, filter } from 'rxjs/operators';
import { Subject, Observable } from 'rxjs';

export interface BroadcastEvent {
  key: any;
  data?: any;
}
export class Broadcaster {
  private _eventBus: Subject<BroadcastEvent>;

  constructor() {
    this._eventBus = new Subject<BroadcastEvent>();
  }

  broadcast(key: any, data?: any) {
    this._eventBus.next({ key, data });
  }

  on<T>(): Subject<BroadcastEvent> {
    return this._eventBus;

  }
}
