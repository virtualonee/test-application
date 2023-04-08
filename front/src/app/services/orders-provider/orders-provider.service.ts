import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GlobalConstants } from 'src/app/constants/constant';
import { FormGroup } from '@angular/forms';
import { Order } from 'src/app/entity/orders';

@Injectable({
  providedIn: 'root'
})
export class OrdersProviderService {

  url:string = GlobalConstants.url+'/order';
  orders: Order[];

  constructor(private http: HttpClient) { }

  getAll(){
    this.orders = [];

    this.http.get<Order[]>(this.url).subscribe(result => {
      console.log(result);
      result.forEach(order => {
        order.isCollapsedButton=true;
        this.orders.push(order);
      });   
    })
    return this.orders;
  }

  post(orders:FormGroup){
    return this.http.post(GlobalConstants.url+'/order/add', orders.value).subscribe((result) => {
      console.warn('result: ', result);
      window.location.reload();
    });
  }

  update(id:bigint, order:Order){
    return this.http.put(GlobalConstants.url+'/order/'+id+'/updateClientData', order).subscribe((result) => {
      window.location.reload();
    });
  }

  delete(id:bigint){
    this.http.delete(this.url+'/'+String(id)+'/delete')
        .subscribe();

    window.location.reload();
  }
}
