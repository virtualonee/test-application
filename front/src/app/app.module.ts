import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import { ButtonModule } from 'primeng/button';
import {TableModule} from 'primeng/table';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { GoodsComponent } from './components/goods/goods.component';
import { OrdersComponent } from './components/orders/orders.component';
import { CreateFormComponent } from './components/goods/create-form/create-form.component';
import { CreateFormOrdersComponent } from './components/orders/create-form-orders/create-form-orders.component';
import { OrdersGoodsComponent } from './components/orders/orders-goods/orders-goods.component';
import { CreateFormOrdersGoodsComponent } from './components/orders/orders-goods/create-form-orders-goods/create-form-orders-goods.component';

const routes: Routes = [
  { path: '', component: OrdersComponent, pathMatch: 'full'},
  { path: 'goods', component: GoodsComponent},
  { path: 'orders', component: OrdersComponent},
  { path: 'orders/:id', component: OrdersGoodsComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    GoodsComponent,
    OrdersComponent,
    CreateFormComponent,
    CreateFormOrdersComponent,
    OrdersGoodsComponent,
    CreateFormOrdersGoodsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule, 
    RouterModule.forRoot(routes),
    ButtonModule,
    ReactiveFormsModule,
    TableModule,
    FormsModule
    
  ],
  exports: [RouterModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
