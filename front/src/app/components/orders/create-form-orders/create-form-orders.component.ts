import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Validators, FormBuilder } from '@angular/forms';
import { GlobalConstants } from 'src/app/constants/constant';
import { OrdersProviderService } from 'src/app/services/orders-provider/orders-provider.service';

@Component({
  selector: 'app-create-form-orders',
  templateUrl: './create-form-orders.component.html',
  styleUrls: ['./create-form-orders.component.css']
})
export class CreateFormOrdersComponent implements OnInit {

  @Input() isCreateForm:boolean;
  @Output() buttonClick = new EventEmitter();

  orders = this.fb.group({
    client: ['', Validators.required],
    address: ['', Validators.required],
    date: ['', Validators.required]
  });

  isSuccess:boolean = false;

  constructor(private http: HttpClient, private fb: FormBuilder, private provider:OrdersProviderService) { }

  ngOnInit() {
  }

  closeForm(){
    this.buttonClick.emit();
  }

  post(){ 
    this.provider.post(this.orders.value);
  }

}
