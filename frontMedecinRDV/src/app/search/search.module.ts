import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {SearchComponent} from './search.component';
import {RouterModule} from '@angular/router';



@NgModule({
  declarations: [
    SearchComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule
  ],
  exports: [
    SearchComponent
  ]
})
export class SearchModule { }
