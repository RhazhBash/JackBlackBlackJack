import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IPilesList } from './pilesList';
import { IPilesListDealer } from './pilesListDealer';
import { AddCardResponse } from './addCardResponse';
import { IGame } from './game';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PileService {

  private readonly apiURLbase: string = "http://deckofcardsapi.com/api/deck/";
  private readonly serverURLbase: string = "http://localhost:8090/";

  constructor(private http: HttpClient) {

   }

  getPlayerPile(deck_id: string):Observable<IPilesList>{
    return this.http.get<IPilesList>(this.apiURLbase 
                               + deck_id 
                               + "/pile/player/list/");
  }

  getDealerPile(deck_id: string):Observable<IPilesListDealer>{
    return this.http.get<IPilesListDealer>(this.apiURLbase 
                               + deck_id 
                               + "/pile/dealer/list/");
  }

  addCardToPile(deck_id: string, pile_name:string, card_code:string):Observable<AddCardResponse>{
    return this.http.get<AddCardResponse>(this.apiURLbase 
                                + deck_id 
                                + "/pile/"
                                + pile_name
                                +"/add/?cards="
                                + card_code);
  }

  sendPlayerPile(piles: IPilesList): Observable<IGame>{
    return this.http.post<IGame>(this.serverURLbase + "/game/hit/player", piles);
  }

  sendDealerPile(pile: IPilesList): Observable<IGame>{
    return this.http.post<IGame>(this.serverURLbase + "/game/hit/dealer", pile);
  }

}
