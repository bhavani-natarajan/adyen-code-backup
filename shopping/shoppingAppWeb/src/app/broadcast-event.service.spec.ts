import { TestBed } from '@angular/core/testing';

import { BroadcastEventService } from './broadcast-event.service';

describe('BroadcastEventService', () => {
  let service: BroadcastEventService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BroadcastEventService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
