import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Validators, FormBuilder } from '@angular/forms';
import { GlobalConstants } from 'src/app/constants/constant';
import { GoodsProviderService } from 'src/app/services/goods-provider/goods-provider.service';

@Component({
  selector: 'app-create-form',
  templateUrl: './create-form.component.html',
  styleUrls: ['./create-form.component.css']
  
})
export class CreateFormComponent implements OnInit {

  @Input() isCreateForm:boolean;
  @Output() buttonClick = new EventEmitter();

  goods = this.fb.group({
    name: ['', Validators.required],
    price: ['', Validators.required]
  });

  isSuccess:boolean = false;

  constructor(private http: HttpClient, private fb: FormBuilder, private provider:GoodsProviderService) { }

  ngOnInit() {
  }

  closeForm(){
    this.buttonClick.emit();
  }

  post(){ 
    this.provider.post(this.goods);
  }
}
