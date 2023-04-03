import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Validators, FormBuilder } from '@angular/forms';
import { GlobalConstants } from 'src/app/constants/constant';

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

  constructor(private http: HttpClient, private fb: FormBuilder) { }

  ngOnInit() {
  }

  closeForm(){
    this.buttonClick.emit();
  }

  post(){ 

    console.log(this.goods.getRawValue());

    return this.http.post(GlobalConstants.url+'/goods/add', this.goods.value).subscribe((result) => {
      console.warn('result: ', result);
      window.location.reload();
    });

    
  }


  

}
