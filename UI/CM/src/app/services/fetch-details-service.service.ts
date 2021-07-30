import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FetchDetails} from 'src/app/models/fetch-details'

@Injectable({
  providedIn: 'root'
})
export class FetchDetailsServiceService {

  constructor(private http:HttpClient) { }


fetchDetails(fetch : FetchDetails){
  let url = "http://localhost:8082/fetchCustomerDetails"
 
  return this.http.get(url,{ responseType: 'json'})
}


}
