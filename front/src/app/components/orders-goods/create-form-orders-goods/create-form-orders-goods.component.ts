import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Validators, FormBuilder } from '@angular/forms';
import { GlobalConstants } from 'src/app/constants/constant';
import { orderLine } from 'src/app/entity/orderLines';
import { Goods } from 'src/app/entity/goods';
import { OrderLineRequest } from 'src/app/entity/orderLineRequest';
import { OrdersGoodsProviderService } from 'src/app/services/orders-goods-provider/orders-goods-provider.service';
import { GoodsProviderService } from 'src/app/services/goods-provider/goods-provider.service';

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

  constructor(private fb: FormBuilder, 
    private orderGoodsProvider:OrdersGoodsProviderService, private goodsProvider:GoodsProviderService) { }

  ngOnInit() {
    this.goodses = this.goodsProvider.getAll();
  }

  closeForm(){
    this.buttonClick.emit();
  }

  post(){ 
    this.orderLineRequest.orderGoods=this.orderId;

    console.log(this.orderLineRequest);

    this.orderGoodsProvider.post(this.orderLineRequest);    
  }
}
