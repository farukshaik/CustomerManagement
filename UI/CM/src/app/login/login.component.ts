import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from  '@angular/forms';
import { Router } from  '@angular/router';
import { User } from  '../user';
import {HttpErrorResponse, HttpResponse} from '@angular/common/http'
import { AuthService } from  '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: any;
  isSubmitted: boolean | undefined;
  message: string="";
  localvariable = {}

  constructor(private authService: AuthService, private router: Router, private formBuilder: FormBuilder) { 
    loginForm: FormGroup;
    const isSubmitted  =  false;
  }

  ngOnInit() {
    this.loginForm  =  this.formBuilder.group({
        userName: ['', Validators.required],
        passWord: ['', Validators.required]
    });
}
get formControls() { return this.loginForm.controls; }

login(){

  this.isSubmitted = true;
  var response: any
  var msg : any
  var result = this.authService.login(this.loginForm.value).subscribe(
    res=>
    {
     var resp= JSON.stringify(res)
      response = JSON.parse(resp)
      msg =  response.message
      console.log(msg)
      //this.router.navigate(['admin'])
      if(msg == "success"){
        //this.router.navigate(['/admin'])
        this.router.navigate(['admin'])
        
      }
      else if(msg == "Not found")
      {
        alert("User does not exist")
        
      }
      else{
        alert("wrong password")
        
      }
      
    })
   
  
  }  
  
  

validate(){
  if((this.loginForm.value.userName!=="admin")&& this.loginForm.value.passWord!=="admin"){
    this.message="wrong inputs"
  }
  else if(this.loginForm.value.passWord!=="admin"){
    this.message="wrong password"
  }
  else if(this.loginForm.value.userName!=="admin"){
  this.message="wrong user name"
  }
}}

