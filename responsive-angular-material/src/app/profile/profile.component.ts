import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../models/user.model';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private userService: UserService) { }

  user: User = JSON.parse(window.localStorage.getItem('loggedUser'));

  ngOnInit() {

    console.log(this.userService.user);
  }

}
