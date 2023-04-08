import { TestBed } from '@angular/core/testing';

import { GoodsProviderService } from './goods-provider.service';

describe('GoodsProviderService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GoodsProviderService = TestBed.get(GoodsProviderService);
    expect(service).toBeTruthy();
  });
});
