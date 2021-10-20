import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  isCollapsed: boolean =true; 
  constructor() { }
  toggleCollapse(){
    this.isCollapsed = !this.isCollapsed;
  }
  ngOnInit(): void {
  }

}
