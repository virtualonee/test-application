import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateFormOrdersComponent } from './create-form-orders.component';

describe('CreateFormOrdersComponent', () => {
  let component: CreateFormOrdersComponent;
  let fixture: ComponentFixture<CreateFormOrdersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateFormOrdersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateFormOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
