import { TestBed } from '@angular/core/testing';

import { OrdersProviderService } from './orders-provider.service';

describe('OrdersProviderService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OrdersProviderService = TestBed.get(OrdersProviderService);
    expect(service).toBeTruthy();
  });
});
