import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  public attemptLogin(){
      
      console.log("It's working!");
      return this.http.get('http://localhost:8082/FacelessBook/posts')
  }
}
