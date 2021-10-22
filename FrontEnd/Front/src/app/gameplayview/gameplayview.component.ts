import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DeckService } from '../deck.service';
import { TransferService } from '../services/game-bet.service';

@Component({
  selector: 'app-gameplayview',
  templateUrl: './gameplayview.component.html',
  styleUrls: ['./gameplayview.component.css'],
  providers: [DeckService, TransferService]
})
export class GameplayviewComponent implements OnInit {
  isCollapsed: boolean =true;
  bet:number = 0;

  constructor(public deckService:DeckService, public transferService:TransferService, private router:Router) { }
  
  toggleCollapse(){
    this.isCollapsed = !this.isCollapsed;
  }

  

  ngOnInit(): void {
  }

  

}



