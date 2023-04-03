import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/entity/orders';
import { GlobalConstants } from 'src/app/constants/constant';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  public isCreateForm:boolean=false;
  orders: Order[] = [];
  url:string = GlobalConstants.url+'/order';

  constructor(private http: HttpClient, private router: Router) {
    this.http.get<Order[]>(this.url).subscribe(result => {
      console.log(result);
      result.forEach(order => {
        order.isCollapsedButton=true;
        console.log(order.date.getDate);
        this.orders.push(order);
      });   
    })
  }

  update(id:bigint){
    
    const order = this.orders.find(element => 
      element.id==id
    );
    console.log(id);
    console.log(order);

    return this.http.put(GlobalConstants.url+'/order/'+id+'/updateClientData', order).subscribe((result) => {
      console.warn('result: ', result);
      window.location.reload();
    });
  }

  deleteOrder(id:bigint){
    this.http.delete(this.url+'/'+String(id)+'/delete')
        .subscribe();
    
    window.location.reload();
  }

  ngOnInit() {
    
  }

  callForm(){
    this.isCreateForm=true;
  }

  closeForm(){
    this.isCreateForm=false;
  }

  toggleCollapse(id:bigint){
    this.orders.map(element => {
      if(element.id==id){
        element.isCollapsedButton=!element.isCollapsedButton;
        return;
      }
    })
    
  }

}
