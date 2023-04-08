import { Component, OnInit } from '@angular/core';
import { Goods } from 'src/app/entity/goods';
import { GlobalConstants } from 'src/app/constants/constant';
import { GoodsProviderService } from 'src/app/services/goods-provider/goods-provider.service';



@Component({
  selector: 'app-goods',
  templateUrl: './goods.component.html',
  styleUrls: ['./goods.component.css']
})
export class GoodsComponent implements OnInit {

  public isCreateForm:boolean=false;
  goodses: Goods[] = [];
  url:string = GlobalConstants.url+'/goods';

  constructor(private provider:GoodsProviderService) {
  }

  ngOnInit() {
    this.goodses = this.provider.getAll();
  }

  update(id:bigint){
    const goods = this.goodses.find(element => 
      element.id==id
    );

    this.provider.update(id, goods);
  }

  callForm(){
    this.isCreateForm=true;
  }

  closeForm(){
    this.isCreateForm=false;
  }

  deleteGoods(id:bigint){
    this.provider.delete(id);
  }

  toggleCollapse(id:bigint){
    this.goodses.map(element => {
      if(element.id==id){
        element.isCollapsedButton=!element.isCollapsedButton;
        return;
      }
    })
    
  }
}