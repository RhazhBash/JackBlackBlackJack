import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DeckService } from '../deck.service';

@Component({
  selector: 'app-pregame-view',
  templateUrl: './pregame-view.component.html',
  styleUrls: ['./pregame-view.component.css']
})
export class PregameViewComponent implements OnInit {

  

  constructor(private router:Router, private deckService:DeckService) { }

  ngOnInit(): void {
  }

}
