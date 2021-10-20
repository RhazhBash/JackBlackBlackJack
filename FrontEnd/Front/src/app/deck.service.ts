import { HttpClient } from '@angular/common/http';
import { isDelegatedFactoryMetadata } from '@angular/compiler/src/render3/r3_factory';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { theDeck } from './deck';
import { IGame } from './game';


@Injectable({
  providedIn: 'root'
})
export class DeckService {
  private url: string = "http://deckofcardsapi.com/api/deck/new/"
  private readonly serverURLbase: string = "http://localhost:8090/";
  constructor(private http: HttpClient) { }
  
  getCard(): Observable<theDeck>{
    return this.http.get<theDeck>(this.url
                                  + "draw/"
                                  +"?count=1/");
  }
  postBet(playerBet: number): Observable<IGame>{
    return this.http.post<IGame>(this.serverURLbase +"player/bet/", playerBet)
  }
  gameStart(gameState: number): Observable<IGame>{
    return this.http.post<IGame>(this.serverURLbase +"game/start/", gameState)
  }
  playerAddCard(playerHand:string[]): Observable<IGame>{
    return this.http.post<IGame>(this.serverURLbase+"pile/player/",playerHand)

  }
  dealerAddCard(dealerHand:string[]): Observable<IGame>{
    return this.http.post<IGame>(this.serverURLbase+"pile/dealer", dealerHand)
  }
  



}
