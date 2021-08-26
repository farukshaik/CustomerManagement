import { Injectable } from '@angular/core';
import { HttpParams } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdminserviceService {

  constructor(private http:HttpClient) { }
  public covid19Reports(id:any){
    console.log(id)
    let param1= new HttpParams().set("id",id)
    return this.http.get('http://localhost:3000/comments',{params:param1})
  }
  getData(){
    let url="https://jsonplaceholder.typicode.com/users";
    return this.http.get(url);
  }
  public covid19Reports1(){
    return this.http.get('http://localhost:3000/comments')
  }


}
