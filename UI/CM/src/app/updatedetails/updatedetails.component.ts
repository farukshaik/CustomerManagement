import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { CoronaserviceService } from '../services/coronaservice.service';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../auth.service';
import { Alldetails } from '../models/alldetails';
import { MatRadioModule } from '@angular/material/radio';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatFormField} from '@angular/material/form-field'
import{MatInput, MatInputModule}from '@angular/material/input';
import {Address} from '../models/address'
import {Profile} from '../models/profile'
import {Occupation} from '../models/occupation'
import {Nominee} from '../models/nominee'
import {Accountdetails} from '../models/accountdetails'
import {Lookupdata} from '../models/lookupdata'
import {CustomerdetailsComponent} from 'src/app/customerdetails/customerdetails.component'

@Component({
  selector: 'app-updatedetails',
  templateUrl: './updatedetails.component.html',
  styleUrls: ['./updatedetails.component.css']
})

export class UpdatedetailsComponent  {
aadharDisable:boolean = true


  productType1:Lookupdata[] = []
accountStatus1:Lookupdata[] = []
branch1 :Lookupdata[] = []
riskLevel1 :Lookupdata[] = []
  alert:boolean=false
  email = new FormControl('');
  activeTab!: string;
  //email = new FormControl('');
  fd: any;
  results:any;
  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }
  //url = 'http://localhost:3000/comments';
  edituserprofileForm = new FormGroup({
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    DOB: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.required, Validators.email]),
    gender: new FormControl('', Validators.required),
    maritalStatus: new FormControl('', Validators.required),
    fathername: new FormControl('', Validators.required),
    mothername: new FormControl('', Validators.required),
    pan: new FormControl('', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]),
    adhar: new FormControl('', [Validators.required,  Validators.minLength(12), Validators.maxLength(12)]),
  });

  addressForm= new FormGroup({
    customerPinCode:new FormControl('',Validators.required),
    customerState:new FormControl('',Validators.required),
    customerCountry:new FormControl('',Validators.required),
    permanentAddress:new FormControl('',Validators.required),
    currentAddress:new FormControl('',Validators.required),
  });


  employeeForm=new FormGroup({
    employeeId:new FormControl('',Validators.required),
    //Employeenature:new FormControl(''),
    companyName:new FormControl('',Validators.required),
    designation:new FormControl('',Validators.required),
    experience:new FormControl('',Validators.required),
    address:new FormControl('',Validators.required),
    state:new FormControl('',Validators.required),
    country:new FormControl('',Validators.required),
    pinCode:new FormControl('',[Validators.required,Validators.minLength(6),Validators.maxLength(6)]),
   });



   nomineeForm=new FormGroup({
    nomineeName:new FormControl('',Validators.required),
    relationship:new FormControl('',Validators.required),
    mobileNumber:new FormControl('',Validators.required),
   });
   
   profile = new Profile('','',new Date(),'','','','','','','','')

   customerAddress = new Address('','','','','',0)
   
   occupation = new Occupation('','','','',0,'','','','',0)
   
   nominee = new Nominee('','','',0)
   data: Lookupdata =new Lookupdata(0,'','','')
   accountDetails:Accountdetails
 
   new(){
    this.router.navigateByUrl('/forms');
  }
  Home(){
    this.router.navigateByUrl('/usertable');
  }
  onHome()
  {
    this.router.navigateByUrl('/admin');
  }
  logout(){
    this.authService.logout();
    this.router.navigateByUrl('/login');
  }
  Admin(){
    this.router.navigateByUrl('/admin');
  }
  cancel(){
    this.router.navigateByUrl('/admin');
  }


  save1() { 
    this.activeTab = "address"
  
    // your logic
  }
    onSubmit(){   
    console.warn(this.nomineeForm.value)
    let url="http://localhost:8082/updatecustomernominee"
    this.httpClient.post(url,this.nomineeForm.value).subscribe((data)=>{
      console.warn(data)
       this.alert=true
      //this.nomineeForm.reset({})
    })  
    }  
    closeAlert(){
      this.alert=false
    }

    onProfile(){
      let url = "http://localhost:8082/updatecustomerdetails"
      console.warn(this.edituserprofileForm.value)
      this.httpClient.post(url,this.edituserprofileForm.value).subscribe((data)=>{
        console.warn(data)
       
         this.alert=true
        //this.userprofileForm.reset({})
  
     })
    }
     onAddress(){
      console.warn(this.addressForm.value)
      let url = "http://localhost:8082/updatecustomeraddress"
      this.httpClient.post(url,this.addressForm.value).subscribe((data)=>{
        console.warn(data)
       
         //this.alert=true
        //this.addressForm.reset({})
  
     })
    }
    onEmployee(){
     // console.warn(this.employeeForm.value)
     let url = "http://localhost:8082/updatecustomeroccupation"
      this.httpClient.post(url,this.employeeForm.value).subscribe((data)=>{
        console.log(this.employeeForm.value)
        
        this.alert=true
       // this.employeeForm.reset({})
  
     })
    }

  constructor(private uform:CoronaserviceService,private custDetails: CustomerdetailsComponent, private rout:ActivatedRoute,private http:HttpClient,
    
    private fb:FormBuilder, private authService:AuthService, private httpClient:HttpClient, private router:Router)

    
    { }
  
value:boolean = this.custDetails.isCompleted

  ngOnInit(): void {
    let url ="http://localhost:8082/getlookupdata"
    this.http.get(url).subscribe((res)=>
      {
        console.log(res)
        var resp= JSON.stringify(res)
      let response = JSON.parse(resp)
      // this.accountStatus =  Array.from(response.AccountStatus)
      this.productType1 =  Array.from(response.ProductType)
      this.accountStatus1 =  Array.from(response.AccountStatus)
      this.branch1 =  Array.from(response.Branch)
      this.riskLevel1 =  Array.from(response.RiskLevel)
      
     // console.log(this.msg)
        
        console.log(this.productType1)
      })
  


   // console.warn(this.rout.snapshot.params.id)
  this.uform.getCurrentForm(this.rout.snapshot.params.customerId).subscribe((results)=>{
    //console.warn(results)
    this.fd=results
    var res=JSON.stringify(results)
    var res1=JSON.parse(res)
    console.log(res1)
    this.fd=res1
    console.log(this.fd.maritalStatus)
    console.log(this.fd.customerPinCode)



    this.accountDetails = new Accountdetails(0,0,0,0,0,this.fd.accountBalance,this.fd.accountTurnOver,this.fd.cashTurnOver,this.fd.purposeOfAccount)
   //let url ="http://localhost:3000/comments"
   
  // this.http.get<[]>(url).subscribe(res=>{
   this.edituserprofileForm = new FormGroup({
    firstName: new FormControl(this.fd.firstName, Validators.required),
    lastName: new FormControl(this.fd.lastName, Validators.required),
    DOB: new FormControl(this.fd.dateOfBirth, Validators.required),
    email: new FormControl(this.fd.emailId, [Validators.required, Validators.email]),
    gender: new FormControl(this.fd.gender, Validators.required),
    maritalStatus: new FormControl(this.fd.maritalStatus, Validators.required),
    fathername: new FormControl(this.fd.fatherName, Validators.required),
    mothername: new FormControl(this.fd.motherName, Validators.required),
    pan: new FormControl(this.fd.panNumber, [Validators.required, Validators.minLength(10), Validators.maxLength(10)]),
    adhar: new FormControl(this.fd.aadharNumber,  [Validators.required, Validators.minLength(12), Validators.maxLength(12)] ),
  });
  

  this.addressForm= new FormGroup({
    customerPinCode:new FormControl(this.fd.customerPinCode,Validators.required),
    customerState:new FormControl(this.fd.customerState,Validators.required),
    customerCountry:new FormControl(this.fd.customerCountry,Validators.required),
    permanentAddress:new FormControl(this.fd.permanentAddress,Validators.required),
    currentAddress:new FormControl(this.fd.currentAddress,Validators.required),
    custId:new FormControl(this.rout.snapshot.params.customerId)
  });



  this.employeeForm=new FormGroup({
    employeeId:new FormControl(this.fd.employeeId,Validators.required),
    companyName:new FormControl(this.fd.companyName,Validators.required),
    designation:new FormControl(this.fd.designation,Validators.required),
    experience:new FormControl(this.fd.experience,Validators.required),
    address:new FormControl(this.fd.address,Validators.required),
    state:new FormControl(this.fd.state,Validators.required),
    country:new FormControl(this.fd.country,Validators.required),
    custId:new FormControl(this.rout.snapshot.params.customerId),
    
    pinCode:new FormControl(this.fd.pinCode,[Validators.required,Validators.minLength(6),Validators.maxLength(6)]),
   });

   this.nomineeForm=new FormGroup({
    nomineeName:new FormControl(this.fd.nomineeName,Validators.required),
    relationship:new FormControl(this.fd.relationship,Validators.required),
    mobileNumber:new FormControl(this.fd.mobileNumber,Validators.required),
    custId:new FormControl(this.rout.snapshot.params.customerId)
   });
})

  }

  


  newProfile()
{
 this.profile = new Profile('','',new Date(),'','','','','','','','')
}

newAddress(){
  this.customerAddress = new Address('','','','','',0)

}

newOccupation()
{
    this.occupation = new Occupation('','','','',0,'','','','',0)
}

newNominee()
{
  this.nominee = new Nominee('','','',0)

}

newAccount()
{
     this.accountDetails = new Accountdetails(0,0,0,0,0,0,0,0,'')
}

onAccount()
  {
    console.log('aaaa')
    console.log('aaa'+this.accountDetails.productType)
    let url = "http://localhost:8082/saveAccountDetails"
    this.accountDetails.custId = this.rout.snapshot.params.customerId
    this.http.post(url,this.accountDetails).subscribe((res)=>{
      console.log(res)
    })
    this.router.navigate(['/admin']) 
  }


  

}

  /*
  collection(){
    console.warn("element",this.edituserprofileForm.value)
    this.uform.updateForm(this.rout.snapshot.params.id,this.edituserprofileForm.value).subscribe((results)=>{
      console.warn("results",results)
      alert("data updated")
    })
  }*/

