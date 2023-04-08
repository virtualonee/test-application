import { TestBed } from '@angular/core/testing';

import { OrdersGoodsProviderService } from './orders-goods-provider.service';

describe('OrdersGoodsProviderService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OrdersGoodsProviderService = TestBed.get(OrdersGoodsProviderService);
    expect(service).toBeTruthy();
  });
});
