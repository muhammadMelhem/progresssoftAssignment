import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DealFormComponent } from './deal-form/deal-form.component';

const routes: Routes = [
   { path: 'findDealById', component: DealFormComponent },
 ];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }