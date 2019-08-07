import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private service: LoginService) { }

  ngOnInit() {
  }

  getLoginService() {
      this.service.attemptLogin().subscribe(
          response => this.handleSuccessfulResponse(response)
      );
  }

  handleSuccessfulResponse(response){
      console.log(response);
  }

}
