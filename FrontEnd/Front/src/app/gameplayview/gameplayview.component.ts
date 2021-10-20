import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-gameplayview',
  templateUrl: './gameplayview.component.html',
  styleUrls: ['./gameplayview.component.css']
})
export class GameplayviewComponent implements OnInit {
  isCollapsed: boolean =true;
  constructor() { }
  toggleCollapse(){
    this.isCollapsed = !this.isCollapsed;
  }

  ngOnInit(): void {
  }

}
