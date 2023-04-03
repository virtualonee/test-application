import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateFormOrdersGoodsComponent } from './create-form-orders-goods.component';

describe('CreateFormOrdersGoodsComponent', () => {
  let component: CreateFormOrdersGoodsComponent;
  let fixture: ComponentFixture<CreateFormOrdersGoodsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateFormOrdersGoodsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateFormOrdersGoodsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
