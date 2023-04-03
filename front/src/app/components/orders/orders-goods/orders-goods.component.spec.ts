import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdersGoodsComponent } from './orders-goods.component';

describe('OrdersGoodsComponent', () => {
  let component: OrdersGoodsComponent;
  let fixture: ComponentFixture<OrdersGoodsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrdersGoodsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdersGoodsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
