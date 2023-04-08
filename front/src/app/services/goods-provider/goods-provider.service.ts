import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Goods } from 'src/app/entity/goods';
import { GlobalConstants } from 'src/app/constants/constant';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class GoodsProviderService {

  url:string = GlobalConstants.url+'/goods';
  goodses: Goods[];

  constructor(private http: HttpClient) { }

  getAll(){
    this.goodses = [];

    this.http.get<Goods[]>(this.url).subscribe(result => {
      result.forEach(goods => {
        goods.isCollapsedButton=true;
        this.goodses.push(goods);
      });
    })
    return this.goodses;
  }

  post(goods:FormGroup){
    return this.http.post(this.url+'/add', goods.value).subscribe((result) => {
      window.location.reload();
    });
  }

  update(id:bigint, goods:Goods){
    return this.http.put(this.url+'/'+id+'/update', goods).subscribe((result) => {
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
