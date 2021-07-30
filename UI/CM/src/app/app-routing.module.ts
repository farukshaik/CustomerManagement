import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import { AuthGuard } from 'src/app/auth.guard';
import { UserTableComponent } from './components/usertable/usertable.component';
import { FormsComponent } from './forms/forms.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'login'},
  { path: 'login', component: LoginComponent },
  {path:'usertable',component:UserTableComponent},
  { path: 'admin', component: AdminComponent },
  { path: 'forms', component: FormsComponent }
];


//canActivate: [AuthGuard]
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }