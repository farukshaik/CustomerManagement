import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { AdminserviceService } from '../services/adminservice.service';
import { Router } from '@angular/router';
import {FetchDetails} from 'src/app/models/fetch-details'
import { ActivatedRoute,ParamMap } from '@angular/router';
import { HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NavigationStart } from '@angular/router';
import {AuthService} from '../auth.service';
import {CustomerdetailsComponent} from 'src/app/customerdetails/customerdetails.component'

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
//const FD: FetchDetails[] = []
export class AdminComponent implements OnInit {

  title="CM";
  fetchDetailsArr = new Array()
  fD:FetchDetails[] = []
  //fetchDetails : FetchDetails[]
  //ELEMENT_DATA : CountryReports[];
  displayedColumns: string[] = ['customerId', 'firstName', 'accountNumber', 'cifNumber','aadharNumber','actions'];

  dataSource =  new MatTableDataSource<FetchDetails>()
  //= new MatTableDataSource<FetchDetails>(this.fetchDetailsArr);
  
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  
  
  
  constructor(private authService: AuthService,private custDetails:CustomerdetailsComponent ,private activate:ActivatedRoute, private router: Router,private http:HttpClient,private service:AdminserviceService) { }
//res = {} as FetchDetails
//fetchDetails = {} as FetchDetails
    value:boolean = this.custDetails.isCompleted
ngAfterViewInit() {
  this.dataSource.sort = this.sort;
  this.dataSource.paginator = this.paginator;
}
ngOnInit(): void { 

     
    let url = "http://localhost:8082/fetchCustomerDetails"
 
    this.http.get<FetchDetails[]>(url).subscribe(res=>{
        //console.log(res)
        this.fD = res
        this.dataSource = new MatTableDataSource(this.fD)
        this.dataSource.sort = this.sort;
  this.dataSource.paginator = this.paginator;
        for(let i=0;i<res.length;i++){
          let fetchDetails = new FetchDetails(0,0,'',0,'',new Date(),'','','','','',new Date(),'','','','')
          fetchDetails = res[i]
          this.fetchDetailsArr.push(fetchDetails)
        //this.fetchDetails.firstName = res[firstName]
        }
       // console.log(this.fetchDetailsArr)
        
      })
      //console.log(this.rowData)
     //this.dataSource = new MatTableDataSource(this.fetchDetailsArr);
    
      console.log(this.dataSource)
    //this.getAllReports();
    }
  
  
   
   /*
   public getAllReports(){
     let resp=this.service.covid19Reports1();
       resp.subscribe(report=>this.dataSource.data=report as CountryReports[]);
   }
*/
  










 new(){
    this.router.navigateByUrl('/customer');
  }
  Home(){
    this.router.navigateByUrl('/usertable');
  }
  logout(){
    this.authService.logout();
    this.router.navigateByUrl('/login');
  }

  client(){
    this.router.navigateByUrl('/covid19');
  }

onAdd()
{
  this.router.navigateByUrl('/customer')
}

edit(){
    this.router.navigateByUrl('/edit');
  }


  //edit2(custId:any){
    
    //console.log(custId)
    //this.router.navigateByUrl('/update/:custId')
    // this.service.covid19Reports(id).subscribe(res=>{
    //   console.log(res)
    //   this.router.navigateByUrl('/update/:id');
    // })
  //}

}