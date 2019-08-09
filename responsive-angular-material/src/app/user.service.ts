import { Injectable } from '@angular/core';
import { Cred } from './models/cred.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from './models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

private baseUrl: string = "http://ec2-54-196-29-226.compute-1.amazonaws.com:8082/FacelessBook-0.0.1-SNAPSHOT/users/login";
private registerUrl: string="http://ec2-54-196-29-226.compute-1.amazonaws.com:8082/FacelessBook-0.0.1-SNAPSHOT/users/signup"

  public user: User;

  constructor(private http: HttpClient) { }

  public loginUser(bob) {
    return this.http.post<any>(this.baseUrl, bob);

  }

  public registerUser(bob){
    console.log(bob)
    return this.http.post<any>(this.registerUrl, bob);
  }

}
