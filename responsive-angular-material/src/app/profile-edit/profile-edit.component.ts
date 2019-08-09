import { Component, OnInit } from '@angular/core';
import { User } from '../models/user.model';
import { UpdateUser } from '../models/updateUser.model'
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.css']
})
export class ProfileEditComponent implements OnInit {

  constructor(private userService: UserService,
              private _router: Router) { }

  user: User = JSON.parse(window.localStorage.getItem('loggedUser'));

  u: UpdateUser = {
    firstName:"", //empty for new firstName
    lastName:"", //empty for new lastName
    username: this.user.username,
    moderatorStatus: 0,
    accessPermission: 1,
    email: "", //empty for new email
    imageURL: this.user.imageURL
  }

  public updateUser(): void {
    this.userService.updateUser(this.u)
    .subscribe(
      resp => {window.localStorage.setItem('loggedUser', JSON.stringify(this.u)), 
      this._router.navigate(['/profile'])},

      error => {window.localStorage.setItem('loggedUser', JSON.stringify(this.u)),
      this._router.navigate(['/profile'])}
    );
  }

  ngOnInit() {
  }

}
