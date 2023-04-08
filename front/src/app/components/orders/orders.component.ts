import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/entity/orders';
import { GlobalConstants } from 'src/app/constants/constant';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { OrdersProviderService } from 'src/app/services/orders-provider/orders-provider.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  public isCreateForm:boolean=false;
  orders: Order[] = [];
  url:string = GlobalConstants.url+'/order';

  constructor(private router: Router, private provider:OrdersProviderService) {}

  update(id:bigint){    
    const order = this.orders.find(element => 
      element.id==id
    );

    this.provider.update(id, order);
  }

  deleteOrder(id:bigint){
    this.provider.delete(id);
  }

  ngOnInit() {
    this.orders = this.provider.getAll();
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
