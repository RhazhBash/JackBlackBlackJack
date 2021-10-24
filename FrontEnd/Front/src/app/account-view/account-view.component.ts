import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-account-view',
  templateUrl: './account-view.component.html',
  styleUrls: ['./account-view.component.css']
})
export class AccountViewComponent implements OnInit {

  chips = 10
  name = ''
  email = ''
  username = ''
  password = ''
  public user : any
  constructor(
    private http:HttpClient,
    private userService:UserService
  ) { 
  }

  ngOnInit(): void {
    //this.http.post('http://localhost:8090/user/get', localStorage.getItem("id_token"))
    //.subscribe(user => this.acountView(user))
    this.userService.getUser()
      .subscribe(data => this.user = data)
  }

  acountView(userInfo:any){

  }
}
