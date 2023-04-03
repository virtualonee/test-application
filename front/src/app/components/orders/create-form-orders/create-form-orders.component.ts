import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Validators, FormBuilder } from '@angular/forms';
import { GlobalConstants } from 'src/app/constants/constant';

@Component({
  selector: 'app-create-form-orders',
  templateUrl: './create-form-orders.component.html',
  styleUrls: ['./create-form-orders.component.css']
})
export class CreateFormOrdersComponent implements OnInit {

  @Input() isCreateForm:boolean;
  @Output() buttonClick = new EventEmitter();

  orders = this.fb.group({
    client: ['', Validators.required],
    address: ['', Validators.required],
    date: ['', Validators.required]
  });

  isSuccess:boolean = false;

  constructor(private http: HttpClient, private fb: FormBuilder) { }

  ngOnInit() {
  }

  closeForm(){
    this.buttonClick.emit();
  }

  post(){ 

    console.log(this.orders.getRawValue());

    return this.http.post(GlobalConstants.url+'/order/add', this.orders.value).subscribe((result) => {
      console.warn('result: ', result);
      window.location.reload();
    });

    
  }

}
