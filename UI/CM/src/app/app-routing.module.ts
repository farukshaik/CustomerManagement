import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import { AuthGuard } from 'src/app/auth.guard';
import { UserTableComponent } from './components/usertable/usertable.component';
import {CustomerdetailsComponent} from './customerdetails/customerdetails.component'
import { UpdatedetailsComponent } from './updatedetails/updatedetails.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'login'},
  { path: 'login', component: LoginComponent },
  {path:'usertable',component:UserTableComponent},
  { path: 'admin', component: AdminComponent},
  { path: 'customer', component: CustomerdetailsComponent},
  {path: 'update/:customerId', component: UpdatedetailsComponent}
];


//canActivate: [AuthGuard]
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }