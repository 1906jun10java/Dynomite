import { Component, OnInit } from '@angular/core';
//import { Cred } from '../models/cred.model';
import { UserService } from '../user.service';
import { User } from '../models/user.model';
import { Cred } from '../models/cred.model';
import { Router } from '@angular/router'

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {

  cred: Cred = {
     username: "",
     pass: ""  
  }

  storage = window.localStorage;
  
  constructor(private userService: UserService,
              private _router: Router) { 
    
  }

  public login(): void {
    console.log(this.cred);
    this.userService.loginUser(this.cred)
      .subscribe(
        resp =>  {this.storage.setItem('loggedUser', JSON.stringify(resp)),        //resp => this.storage.setItem('loggedUser', resp),
        this._router.navigate(['/globalview'])},
        error => {console.log(error),
        this._router.navigate([''])}
      );
    this.userService.user = JSON.parse(this.storage.getItem('loggedUser'));
    console.log(this.userService.user);

  }

  ngOnInit() {
  }

}
