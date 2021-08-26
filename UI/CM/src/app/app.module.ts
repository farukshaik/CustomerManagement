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
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatFormField} from '@angular/material/form-field'
import{MatInput, MatInputModule}from '@angular/material/input';
import { MatOption } from '@angular/material/core';
import { MatRadioModule } from '@angular/material/radio';
import{MatTabsModule} from'@angular/material/tabs';
import{MatMenuModule} from '@angular/material/menu';
import{matMenuAnimations} from '@angular/material/menu';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatCalendarView} from '@angular/material/datepicker/calendar';
import {MatSelectModule} from '@angular/material/select';
import { CustomerdetailsComponent } from './customerdetails/customerdetails.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { UpdatedetailsComponent } from './updatedetails/updatedetails.component'


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminComponent,
    UserTableComponent,
    CustomerdetailsComponent,
    UpdatedetailsComponent
    
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
    MatRadioModule,
    MatIconModule,
    AgGridModule.withComponents([]),
    MatButtonModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatMenuModule,
    BrowserAnimationsModule,
    MatDatepickerModule,
    
  
  ],
  exports:[],
  providers: [UserService, CustomerdetailsComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }