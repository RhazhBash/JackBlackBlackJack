import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IPilesList } from './pilesList';
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

  getPile(deck_id: string, pile_name:string): Observable<IPilesList>{
    return this.http.get<IPilesList>(this.apiURLbase 
                               + deck_id 
                               + "/pile/"
                               + pile_name
                               +"/list/");
  }

  addCardToPile(deck_id: string, pile_name:string, card_code:string):Observable<IPilesList>{
    return this.http.get<IPilesList>(this.apiURLbase 
                                + deck_id 
                                + "/pile/"
                                + pile_name
                                +"/add/?cards="
                                + card_code);
  }

  sendPlayerPiles(piles: IPilesList): Observable<IGame>{
    return this.http.post<IGame>(this.serverURLbase + "/pile/player", piles);
  }

  sendDealerPile(pile: IPilesList): Observable<IGame>{
    return this.http.post<IGame>(this.serverURLbase + "/pile/dealer", pile);
  }

}
