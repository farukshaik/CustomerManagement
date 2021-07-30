import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder, ControlContainer } from '@angular/forms';
import { MaterialModule } from '../material/material.module';
import { HttpClient } from '@angular/common/http';
import { Router } from  '@angular/router';
import { ConditionPosition } from 'ag-grid-community/dist/lib/filter/provided/simpleFilter';
import { validateHorizontalPosition } from '@angular/cdk/overlay';
@Component({
  selector: 'app-forms',
  templateUrl: './forms.component.html',
  styleUrls: ['./forms.component.css']
})

export class FormsComponent {
  email = new FormControl('');
  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }
 


  url='http://localhost:8082/addcustomer';
  
  userprofileForm =new FormGroup({
    firstName: new FormControl('',Validators.required),
    lastName: new FormControl('',Validators.required),
    dateOfBirth: new FormControl('',Validators.required),
    emailId:new FormControl('', [Validators.required, Validators.email]),
    gender:new FormControl('',Validators.required),
    maritalStatus:new FormControl('',Validators.required),
    fatherName:new FormControl('',Validators.required),
    motherName:new FormControl('',Validators.required),
    customerMobileNumber:new FormControl('',[Validators.required,Validators.minLength(10),Validators.maxLength(10)]),
    
    customerPinCode:new FormControl('',Validators.required),
    customerState:new FormControl('',Validators.required),
    customerCountry:new FormControl('',Validators.required),
    permanentAddress:new FormControl('',Validators.required),
    currentAddress:new FormControl('',Validators.required),

    employeeId:new FormControl('',Validators.required),
    employeeNature:new FormControl(''),
    companyName:new FormControl('',Validators.required),
    designation:new FormControl('',Validators.required),
    experience:new FormControl('',Validators.required),
    address:new FormControl('',Validators.required),
    state:new FormControl('',Validators.required),
    country:new FormControl('',Validators.required),
    pincode:new FormControl('',[Validators.required,Validators.minLength(6),Validators.maxLength(6)]),
    
    nomineeName:new FormControl('',Validators.required),
    relationship:new FormControl('',Validators.required),
    mobileNumber:new FormControl('',[Validators.required,Validators.minLength(10),Validators.maxLength(10)]),
   
    panNumber:new FormControl('',[Validators.required,Validators.minLength(10),Validators.maxLength(10)]),
    aadharNumber:new FormControl('',[Validators.required,Validators.minLength(12),Validators.maxLength(12)]),
  });

  new(){
    this.route.navigateByUrl('/forms');
  }
  Home(){
    this.route.navigateByUrl('/usertable');
  }
  logout(){
    
    this.route.navigateByUrl('/login');
  }
  Admin(){
    this.route.navigateByUrl('/admin');
  }


  constructor(private fb:FormBuilder,private httpClient:HttpClient,private route:Router){

  }
   response:any
   msg:any
    onSubmit(){   
      console.log(this.userprofileForm)
    console.warn(this.userprofileForm.value)
    this.httpClient.post(this.url,this.userprofileForm.value).subscribe((data)=>{
      var resp= JSON.stringify(data)
      this.response = JSON.parse(resp)
      this.msg =  this.response.message
      console.log(this.msg)
if(this.msg == "exists")
{
  this.route.navigate(['/admin'])
  alert("Data already exists")
}  
else
{
  this.route.navigate(['/admin'])
  alert("Record inserted....")
}
    })



    



    //public userprofileForm=this.fb.group({
      //adhar:['',
        //[Validators.required,Validators.adhar],
        //[
         // this.isAdharUnique.bind(this),
       // ]
      //],
    //})
   // isAdharUnique(control:FormControl){
     // clearTimeout(this.duplicateAdharDbounce);
      //const q= new Promise((resolve,reject)=>{
        //this.duplicateAdharDbounce=setTimeout(()=>{
          //this.apiService.post('url',{"Adhar":Control.value}).subscribe((resp)=>{
            //resolve({'duplicateAdhar':resp['data'].isDuplicate});
          //},()=>{resolbve({'duplicateAdhar':true});});
        //},1000);
          //});
          //return q
    //}
  }
}