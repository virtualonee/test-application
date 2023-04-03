import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Goods } from 'src/app/entity/goods';
import { element } from 'protractor';
import { GlobalConstants } from 'src/app/constants/constant';



@Component({
  selector: 'app-goods',
  templateUrl: './goods.component.html',
  styleUrls: ['./goods.component.css']
})
export class GoodsComponent implements OnInit {

  public isCreateForm:boolean=false;
  goodses: Goods[] = [];
  url:string = GlobalConstants.url+'/goods';

  constructor(private http: HttpClient) {
    this.http.get<Goods[]>(this.url).subscribe(result => {
      console.log(result);
      result.forEach(goods => {
        goods.isCollapsedButton=true;
        this.goodses.push(goods);
      });

      
      
    })
  }

  ngOnInit() {
  }

  update(id:bigint){
    
    const goods = this.goodses.find(element => 
      element.id==id
    );
    console.log(id);
    console.log(goods);

    return this.http.put(GlobalConstants.url+'/goods/'+id+'/update', goods).subscribe((result) => {
      console.warn('result: ', result);
      window.location.reload();
    });
  }

  callForm(){
    this.isCreateForm=true;
  }

  closeForm(){
    this.isCreateForm=false;
  }

  deleteGoods(id:bigint){
    this.http.delete(this.url+'/'+String(id)+'/delete')
        .subscribe();
    
    window.location.reload();
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