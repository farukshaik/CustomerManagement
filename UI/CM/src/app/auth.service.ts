import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';
import { Router } from  '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
result:any
  constructor(private http:HttpClient, private router :Router ) { }

  public login(userInfo: User){
    let url = "http://localhost:8082/login"
 
  var response:any
  var msg:any
  return this.http.post(url,userInfo,{  responseType: 'json'})
  /*.subscribe(
      res=>
      {
       var resp= JSON.stringify(res)
        response = JSON.parse(resp)
        msg =  response.message
        
      }
    )*/
    
    
  }

  public isLoggedIn(){
    return localStorage.getItem('ACCESS_TOKEN') !== null;

  }

  public logout(){
    localStorage.removeItem('ACCESS_TOKEN');
  }

 
}