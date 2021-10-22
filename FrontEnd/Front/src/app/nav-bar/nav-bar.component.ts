import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  isCollapsed: boolean =true; 
  
  message = '(Please Login to begin playing)';
  constructor(
    private http: HttpClient
  ) { 
  }

  toggleCollapse(){
    this.isCollapsed = !this.isCollapsed;
  }
  
  ngOnInit(): void {
 /*   
    this.http.get('http://localhost:8090/user', {withCredentials: true}).subscribe(
      (res: any)=> {
        this.message = 'Hi ${res.name}';
      },
      err => {
        this.message = 'You are not logged in';
      }
    )*/
  }

}
