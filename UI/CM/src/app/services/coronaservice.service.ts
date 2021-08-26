import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CoronaserviceService {

  //url="http://localhost:3000/comments"
  id: any;
  
  constructor(private rout:ActivatedRoute,private http:HttpClient) { }
  // public covid19Reports(){
  //   return this.http.get("http://localhost:3000/comments");
  // }
 // getData(){
   // let url="https://jsonplaceholder.typicode.com/users";
    //return this.http.get(url);
  //}
  public getCurrentForm(customerId: any){
    console.log('uhh'+customerId)
    let url='http://localhost:8082/getalldetails';
    return this.http.get(`${url}/${customerId}`);
  }

  //  updateForm(id: any,data: any){
  //    let url='http://localhost:3000/comments';
  //    return this.http.put(`${this.url}/${id}`,data)
  //  }
}
