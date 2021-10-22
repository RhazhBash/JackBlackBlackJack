import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DeckService } from '../deck.service';

@Component({
  selector: 'app-gameplayview',
  templateUrl: './gameplayview.component.html',
  styleUrls: ['./gameplayview.component.css'],
  providers: [DeckService]
})
export class GameplayviewComponent implements OnInit {
  isCollapsed: boolean =true;


  constructor(
    private deckService:DeckService,
    private router:Router
    ) { 
    }
  
  toggleCollapse(){
    this.isCollapsed = !this.isCollapsed;
  }

  

  ngOnInit(): void {
  }

}



