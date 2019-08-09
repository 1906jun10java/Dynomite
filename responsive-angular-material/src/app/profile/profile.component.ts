import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../models/user.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private userService: UserService,
                private _router: Router) { }

  user: User = JSON.parse(window.localStorage.getItem('loggedUser'));

  routeToEdit()
  {
    this._router.navigate(['/profile-edit'])
  }

  ngOnInit() {
  }

}
