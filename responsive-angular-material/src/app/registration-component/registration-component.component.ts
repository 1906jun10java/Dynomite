import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router'
import { User } from '../models/user.model';

@Component({
  selector: 'app-registration-component',
  templateUrl: './registration-component.component.html',
  styleUrls: ['./registration-component.component.css']
})
export class RegistrationComponentComponent implements OnInit {

  constructor(private userService: UserService,
              private _router: Router) { }


    u: User = {
      firstName:"",
      lastName:"",
      username: "",
      pass: "",
      moderatorStatus: 0,
      accessPermission: 1,
      email: "",
      imageURL: ""
    } 


  public register() :void {
    console.log(this.u)
    this.userService.registerUser(this.u)
    .subscribe(
      resp => {console.log(resp),
      this._router.navigate(['/login'])},
      error => console.log(error)
    );
  }

  ngOnInit() {
  }

}
