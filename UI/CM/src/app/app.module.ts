import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import {MatTableModule} from'@angular/material/table';
import { UserTableComponent } from './components/usertable/usertable.component';
import {HttpClientModule} from'@angular/common/http';
import { UserService } from './services/user.service';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatButton, MatButtonModule } from '@angular/material/button';
import { AgGridModule } from 'ag-grid-angular';
import { FormsComponent } from './forms/forms.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import{MatInput, MatInputModule}from '@angular/material/input';
import { MatOption } from '@angular/material/core';
import{MatTabsModule} from'@angular/material/tabs';
import{MatMenuModule} from '@angular/material/menu';
import{matMenuAnimations} from '@angular/material/menu';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatCalendarView} from '@angular/material/datepicker/calendar';
import {MatSelectModule} from '@angular/material/select';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminComponent,
    UserTableComponent,
    FormsComponent,
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    MatTableModule,
    HttpClientModule,
    MatSortModule,
    MatPaginatorModule,
    MatTabsModule,
    AgGridModule.withComponents([]),
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatMenuModule,
    BrowserAnimationsModule,
    MatDatepickerModule,
  
  
  ],
  exports:[MatSortModule,MatInput,  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }