import { Component, OnInit } from '@angular/core';
import { BasicAuthenticationService } from '../service/basic-authentication.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(
    private isLoggedIn: BasicAuthenticationService
  ) { }

  ngOnInit() {
    this.isLoggedIn.logout();
  }

}
