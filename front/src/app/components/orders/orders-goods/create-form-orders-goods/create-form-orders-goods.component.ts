import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Validators, FormBuilder } from '@angular/forms';
import { GlobalConstants } from 'src/app/constants/constant';
import { orderLine } from 'src/app/entity/orderLines';
import { Goods } from 'src/app/entity/goods';
import { OrderLineRequest } from 'src/app/entity/orderLineRequest';

@Component({
  selector: 'app-create-form-orders-goods',
  templateUrl: './create-form-orders-goods.component.html',
  styleUrls: ['./create-form-orders-goods.component.css']
})
export class CreateFormOrdersGoodsComponent implements OnInit {

  @Input() isCreateForm:boolean;
  @Output() buttonClick = new EventEmitter();
  @Input() orderId:bigint;

  goodses: Goods[] = [];

  orderLineRequest:OrderLineRequest = new OrderLineRequest();

  isSuccess:boolean = false;

  constructor(private http: HttpClient, private fb: FormBuilder) { 

    this.http.get<Goods[]>(GlobalConstants.url+'/goods').subscribe(result => {
      console.log(result);
      result.forEach(goods => {
        goods.isCollapsedButton=true;
        this.goodses.push(goods);
      });

  });
}

  ngOnInit() {
  }

  closeForm(){
    this.buttonClick.emit();
  }

  post(){ 
    this.orderLineRequest.orderGoods=this.orderId;

    console.log(this.orderLineRequest);

    return this.http.post(GlobalConstants.url+'/order_lines/add', this.orderLineRequest).subscribe((result) => {
      console.warn('result: ', result);
      window.location.reload();
    });

    

    
  }

}
