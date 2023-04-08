import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Goods } from 'src/app/entity/goods';
import { GlobalConstants } from 'src/app/constants/constant';
import { FormGroup } from '@angular/forms';
import { Order } from 'src/app/entity/orders';
import { orderLine } from 'src/app/entity/orderLines';
import { OrderLineRequest } from 'src/app/entity/orderLineRequest';

@Injectable({
  providedIn: 'root'
})
export class OrdersGoodsProviderService {

  url:string = GlobalConstants.url+'/order_lines';
  order:Order;
  sum:bigint;
  public isCreateForm:boolean=false;

  constructor(private http: HttpClient) { }

  post(goodsLineRequest:OrderLineRequest){
    return this.http.post(this.url+'/add', goodsLineRequest).subscribe((result) => {
      console.warn('result: ', result);
      window.location.reload();
    });
  }

  update(id:bigint, orderLine:orderLine){
    return this.http.put(this.url+'/'+id+'/update', orderLine).subscribe((result) => {
      console.warn('result: ', result);
      window.location.reload();
    });
  }

  delete(id:bigint){
    this.http.delete(this.url+'/'+String(id)+'/delete')
        .subscribe();
    window.location.reload();
  }
}
