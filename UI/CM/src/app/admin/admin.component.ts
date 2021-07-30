import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import{AgGridAngular} from 'ag-grid-angular';
import{Observable} from 'rxjs';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  columnDefs = [

    { field: 'customerId' ,sortable:true,filter:true},
    { field: 'accountNumber' ,sortable: true,filter:true},
    { field: 'firstName',sortable: true,filter:true},
    { field: 'lastName' ,sortable:true,filter:true},
    { field: 'dateOfBirth' ,sortable:true,filter:true},
    { field: 'gender' ,sortable:true,filter:true},
    { field: 'aadharNumber' ,sortable:true,filter:true},
    { field: 'panNumber' ,sortable:true,filter:true},
    { field: 'mobileNumber' ,sortable:true,filter:true},
    { field: 'emailId' ,sortable:true,filter:true},
    { field: 'accountStatus' ,sortable:true,filter:true},

];



rowData!: Observable<any[]>;
  constructor(private authService: AuthService, private router: Router,private http:HttpClient) { }

    ngOnInit(): void { 
     
    let url = "http://localhost:8082/fetchCustomerDetails"
 
      this.rowData = this.http.get<any[]>(url)
        
      //console.log(this.rowData)
  }
 new(){
    this.router.navigateByUrl('/forms');
  }
  Home(){
    this.router.navigateByUrl('/usertable');
  }
  logout(){
    this.authService.logout();
    this.router.navigateByUrl('/login');
  }

}