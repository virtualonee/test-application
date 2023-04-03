import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Goods } from './entity/goods';
import { GlobalConstants } from './constants/constant';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'test-front';
  goodses: Goods[] = [];
  tempGoods: Goods = new Goods();

  constructor(private http: HttpClient) {
    this.http.get<Goods[]>(GlobalConstants.url+"/goods").subscribe(result => {
      console.log(result);
      result.forEach(goods => {
        
        this.tempGoods.id = goods.id;
        this.tempGoods.name = goods.name;
        this.tempGoods.price = goods.price;

        this.goodses.push(this.tempGoods)
        
      });
      
    })
  }
}
