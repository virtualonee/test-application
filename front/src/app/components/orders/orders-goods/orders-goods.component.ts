import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GlobalConstants } from 'src/app/constants/constant';
import { Order } from 'src/app/entity/orders';
import { HttpClient } from '@angular/common/http';
import { orderLine } from 'src/app/entity/orderLines';
import { element } from 'protractor';

@Component({
  selector: 'app-orders-goods',
  templateUrl: './orders-goods.component.html',
  styleUrls: ['./orders-goods.component.css']
})
export class OrdersGoodsComponent implements OnInit {

  pathId:number;
  order:Order;
  orderLines:orderLine[];
  sum:bigint;
  public isCreateForm:boolean=false;

  constructor(private activatedRoute: ActivatedRoute, private http: HttpClient, private router: Router) { }

  ngOnInit() {

    this.activatedRoute.params.subscribe(s => {
      this.pathId=parseInt(s["id"]);
      
    });

    this.http.get<Order>(GlobalConstants.url+'/order/'+this.pathId+'/get').subscribe(result => {
      this.order=result;
      this.orderLines =this.order.orderLinesDTOS;

      this.order.sum=this.order.id-this.order.id; //TODO 

      this.orderLines.map(element => {
        element.sum=element.count*element.goodsPrice;
        element.isCollapsedButton=true;
        
        this.order.sum+=element.sum;
      })
      }); 
  }

  toggleCollapse(id:bigint){
    this.orderLines.map(element => {
      if(element.id==id){
        element.isCollapsedButton=!element.isCollapsedButton;
        return;
      }
    })
    
  }

  deleteOrderGoods(id:bigint){
    this.http.delete(GlobalConstants.url+'/order_lines/'+String(id)+'/delete')
        .subscribe();
    
    window.location.reload();
  }

  callForm(){
    this.isCreateForm=true;
  }

  closeForm(){
    this.isCreateForm=false;
  }

}
