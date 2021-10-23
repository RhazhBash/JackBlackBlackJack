import { HttpClient } from '@angular/common/http';
import { isDelegatedFactoryMetadata } from '@angular/compiler/src/render3/r3_factory';
import { Injectable, OnInit } from '@angular/core';
//import { stringify } from 'querystring';
import { Observable } from 'rxjs';
//import { runInThisContext } from 'vm';
import { theDeck } from './deck';
import { IDrawResponse } from './draw-card';
import { IGame } from './game';
import { PileService } from './pile.service';

@Injectable({
  providedIn: 'root'
})
export class DeckService {
  private url: string = "http://deckofcardsapi.com/api/deck/"
  private readonly serverURLbase: string = "http://localhost:8090/";
 
  constructor(private http: HttpClient, public pileService:PileService) { }
  public deckID:string =''
  public playerHand:String[] =[]
  public dealerHand:string[]=[]
  public newCard:string=''
  public parsed_NewCard:string[]=[]
  public parsed_Cards:string=''
  public newCardCode:string=''
  public cardsSubCat:string[]=[]
  public cardValue:string=''

  getCard(){
    const Http = new XMLHttpRequest();
    Http.open("GET", this.url+ this.deckID+ "/draw/"+"?count=1/");        //
    Http.send();                                                          //this function draws a new card from the deck api 
    Http.onreadystatechange = (e) => {                                    //using the deck_id from the original deck
      let newCard = (Http.responseText)                                   //
      let parsed_NewCard = JSON.parse(newCard)                            //        this is to get the proper information
                                                                         //        after hittng the deal button
      let allCardStats = parsed_NewCard.cards   
      this.cardValue = allCardStats.value    
      
      
    }

   


    }
  
  

  getDeck(bet2:number){
    

    class fullObject {
        constructor (private bet:number,private playerHand:string[], private dealerHand:string[], private deck_id:string){ //object to be sent to the back end
           this.bet = bet
           this.playerHand = playerHand
           this.dealerHand = dealerHand
           this.deck_id = deck_id
        }
    }

  

    
    const Http = new XMLHttpRequest();                  //
    Http.open("GET", this.url + "new/draw/?count=4");   //  
    Http.send();                                        //  
    Http.onreadystatechange = (e) => {                  //
      let newDeck = (Http.responseText)                 //
      let parsed_deck = JSON.parse(newDeck)             //        this is to get the proper information
      let deckID= parsed_deck.deck_id                   //        after hittng the deal button
      let allCards = parsed_deck.cards                  //
      this.playerHand = [allCards[0], allCards[2]]      //
      this.dealerHand = [allCards[1], allCards[3]]      //
      
      

    }
    //console.log(fullObject)
    //return this.http.post<IGame>(this.serverURLbase +"game/start/", fullObject ) //update the post request to the back end******************************************************



    
    
    
    
   
  }

 


















}
