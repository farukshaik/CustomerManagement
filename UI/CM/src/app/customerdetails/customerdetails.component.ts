import { Component, OnInit } from '@angular/core';
import { Customer } from '../models/customer';
import {HttpClient} from '@angular/common/http'
import { Router } from '@angular/router';
import {Address} from '../models/address'
import {Profile} from '../models/profile'
import {Occupation} from '../models/occupation'
import {Nominee} from '../models/nominee'
import {Accountdetails} from '../models/accountdetails'
import {Lookupdata} from '../models/lookupdata'
import {global} from '../globals';
@Component({
  selector: 'app-customerdetails',
  templateUrl: './customerdetails.component.html',
  styleUrls: ['./customerdetails.component.css']
})
export class CustomerdetailsComponent {

  alert:boolean=false
  isCompleted:boolean = false
  activeTab!: string
  //lookupData  = {} as Lookupdata[]

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
  cancel(){
    this.route.navigateByUrl('/admin');
  }


  onHome()
  {
    this.route.navigateByUrl('/admin');
  }
  
  constructor(private http:HttpClient,private route:Router, private httpClient:HttpClient) { }


//lookupData:Lookupdata[] = []
res:any

productType1:Lookupdata[] = []
accountStatus1:Lookupdata[] = []
branch1 :Lookupdata[] = []
riskLevel1 :Lookupdata[] = []


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
      
      console.log(this.msg)
        
        console.log(this.productType1)
      })
  }
  msg:any
//customer = new Customer('','',new Date(),'','','','','','','','','','','','','','','','',0,'','','','','','','')


profile = new Profile('','',new Date(),'','','','','','','','')

customerAddress = new Address('','','','','',0)

occupation = new Occupation('','','','',0,'','','','',0)

nominee = new Nominee('','','',0)
data: Lookupdata =new Lookupdata(0,'','','')
accountDetails = new Accountdetails(0,0,0,0,0,0,0,0,'')


/*onSubmit()
{
  console.log(this.customer)
  let url = "http://localhost:8082/demo"
  this.http.post(url,this.customer).subscribe((res)=>{
    console.log(res)
  })

}*/
response:any


onProfile() : string{
  //console.warn(this.userprofileForm.value)
  let url = "http://localhost:8082/addcustomerdetails"
  this.httpClient.post(url,this.profile).subscribe((data)=>{
    var resp= JSON.stringify(data)
      this.response = JSON.parse(resp)
      this.msg =  this.response.message
      console.log(this.response)
      console.log(this.msg)
      global.customerId = this.msg
      console.log(global.customerId)
      if(this.msg == 999999)
      {
        //this.route.navigate(['/admin'])
        alert("Data already exists")
      }  
      else
      {
        //this.route.navigate(['/admin'])
        //alert("Personal Details inserted....")
      }  


 }) 
 return this.msg
}
 onAddress() {
  
  console.warn(global.customerId)
  let url = "http://localhost:8082/addcustomeraddress"
 // console.log(myGlobals.aadharNumber)
 this.customerAddress.custId = global.customerId
  this.httpClient.post(url,this.customerAddress).subscribe((data)=>{
    console.log(this.customerAddress)
    
 })
}
onEmployee(){
  let url = "http://localhost:8082/addcustomeroccupation"
  //console.warn(this.occupation)
  this.occupation.custId = global.customerId
  this.httpClient.post(url,this.occupation).subscribe((data)=>{
    console.log(this.occupation)
    
    this.alert=true
    //this.employeeForm.reset({})

 })
}
//save1() { 
  //this.activeTab = "address"

  // your logic
//}
  onSubmit(){   
  //console.warn(this.nomineeForm.value)
  let url = "http://localhost:8082/addcustomernominee"
  this.nominee.custId = global.customerId
    this.httpClient.post(url,this.nominee).subscribe((data)=>{
    console.warn(data)
     this.alert=true
     //this.isCompleted = true
    //this.nomineeForm.reset({})
  }) 
  
  }  
  closeAlert(){
    this.alert=false
  }

  onAccount()
  {
    console.log('aaaa')
    console.log('aaa'+this.accountDetails.productType)
    let url = "http://localhost:8082/saveAccountDetails"
    this.accountDetails.custId = global.customerId
    this.http.post(url,this.accountDetails).subscribe((res)=>{
      console.log(res)
    })
    this.isCompleted = true
    this.route.navigate(['/admin']) 
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


}


 






