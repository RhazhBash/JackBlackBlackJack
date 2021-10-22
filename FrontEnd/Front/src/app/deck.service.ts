import { HttpClient } from '@angular/common/http';
import { isDelegatedFactoryMetadata } from '@angular/compiler/src/render3/r3_factory';
import { Injectable, OnInit } from '@angular/core';
//import { stringify } from 'querystring';
import { Observable } from 'rxjs';
//import { runInThisContext } from 'vm';
import { theDeck } from './deck';
import { IDrawResponse } from './draw-card';
import { IGame } from './game';


@Injectable({
  providedIn: 'root'
})
export class DeckService {
  private url: string = "http://deckofcardsapi.com/api/deck/"
  private readonly serverURLbase: string = "http://localhost:8090/";
 
  constructor(private http: HttpClient) { }
  private deckID:string =''
  


  getCard(): Observable<IGame>{
    //var drawnCard = 
  
   return this.http.get<IGame>(this.url
                                  + this.deckID
                                  + "/draw/"
                                 +"?count=1/");
   }
   
  getDeck(bet2:number):  Observable<IGame>{
    class fullObject {
        constructor (private bet:number,private playerHand:string[], private dealerHand:string[], private deck_id:string){
           this.bet = bet
           this.playerHand = playerHand
           this.dealerHand = dealerHand
           this.deck_id = deck_id
        }
    }

    let newDeck = this.http.get<IDrawResponse>(this.url + "new/draw/?count=4")
    let deck = Object.entries(newDeck); //deck is shown as a JSON object, (sucess, deck_id, remaining, shuffled)
    let deck_idKey = deck[2];          //deck_id array is shown independently
    this.deckID = deck_idKey[1];      //deck_id is seperated from the key 
      
    let usedCards = deck[1]; //pulls "cards" array from the deck
    let usedCards2 = usedCards[1]; //pulls card value from "cards" array
    let playerHand:string[] = [usedCards2[0].value, usedCards2[2].value]; //pulls card value 1 and 3 from values array and puts it in the player hand 
    let dealerHand:string[] = [usedCards2[1].value, usedCards2[3].value]; //pulls card value 2 and 4 from values array and puts it in the dealer hand
    let package2:fullObject = new fullObject(bet2,playerHand,dealerHand,this.deckID); //adds all values to package2, so it can be sent awayyy 

    return this.http.post<IGame>(this.serverURLbase +"game/start/", package2 )
  }

 


















}
