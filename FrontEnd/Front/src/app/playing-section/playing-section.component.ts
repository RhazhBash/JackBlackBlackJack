import { Component, OnInit } from '@angular/core';
import { CardComponent } from '../card/card/card.component';
import { DeckService } from '../deck.service';
import { PileService } from '../pile.service';
import {IGame} from '../../app/game'
import { isDelegatedFactoryMetadata } from '@angular/compiler/src/render3/r3_factory';
import { BehaviorSubject, Subscription } from 'rxjs';
import { TransferService } from '../services/game-bet.service';


@Component({
  selector: 'app-playing-section',
  templateUrl: './playing-section.component.html',
  styleUrls: ['./playing-section.component.css']
})
export class PlayingSectionComponent implements OnInit {
    iGame:IGame;
    public displayMessage:string=''
    public pushMessage:string='No one wins and you get your chips back.'
    public ddCollapse:boolean=true
    public hitStayButtonCollapse:boolean=true
    public subscription: Subscription = new Subscription;
    public item:any
    pot:number=0
  
  bank:number = 1000
  public deckID:string =''
  public playerHand:string[] =[] 
  public dealerHand:string[]=[]
  public newCard:string=''
  public parsed_NewCard:string[]=[]
  public parsed_Cards:string=''
  public newCardCode:string=''
  public cardsSubCat:string[]=[]
  public cardValue:string=''
  public preDeck:boolean=false
  private cardSource =new BehaviorSubject<any>(0)
  cardView =this.cardSource.asObservable();
  public allCards:string[]=[]
  public playerSingleCard1:string=''
  public playerSingleCard2:string=''
  public playerSingleCardImage:any=''
  
  private url: string = "http://deckofcardsapi.com/api/deck/"
  public playerSingleCardImage2:string=''
  public dealerSingleCard1:string=''
  public dealerSingleCard2:string=''
  public dealerSingleCardImage:string=''
  public dealerSingleCardImage2:string=''
  private readonly serverURLbase: string = "http://localhost:8090/";
  public bet:number = 0
  public JWTToken:any=''
  constructor(public cardService:CardComponent, public pileService:PileService, public deckService:DeckService, public transferService:TransferService) {
    this.iGame=<IGame>{};
   }

   


  ngOnInit():void {
    //this.subscription = this.deckService.cardView.subscribe(item => this.item = item)
    this.JWTToken = localStorage.getItem('id_token')
    this.bet=this.transferService.getBet()
    
    
  //this.deckService.getDeck(4)
  
    
    console.log("Curtis")
    const Http = new XMLHttpRequest();                  //
      Http.open("GET", this.url + "new/draw/?count=4");   //  
      Http.send();                                        //  
      Http.onreadystatechange = () => {  
        if (Http.readyState ==4){               
          let newDeck = (Http.responseText)
          console.log(newDeck)                                                
          let parsed_deck = JSON.parse(newDeck)        //getting http response && parsing from JSON
                                       
          console.log(parsed_deck)                                              
          this.deckID= parsed_deck.deck_id             //playing section deck ID

          console.log("*********"+this.deckID+"*********")                //        after hittng the deal button
          this.allCards = parsed_deck.cards                             //playing section array or card objects
          console.log(this.allCards)                
          this.playerHand = [this.allCards[0], this.allCards[2]]      //putting 2 of the 4 drawn cards into a playing section array
          this.dealerHand = [this.allCards[1], this.allCards[3]] 
          this.deckService.deckID=this.deckID  
          console.log(this.playerHand)
          console.log(this.allCards[0])
          console.log(this.playerHand)



          let playerSingleCard:any = this.allCards[0]      //players first card OBJ
          console.log(playerSingleCard)
          let playerSingleCardValues = Object.values(playerSingleCard)
          console.log(playerSingleCardValues)        //value array of player 1st card OBJ
          let playerCardValue=(Object.values(playerSingleCardValues))[0]        //values of players 1st card
         
          console.log(playerCardValue)//code player card
          this.playerSingleCardImage=playerSingleCardValues[1]          //adding first player card img


          /////////////////////////////////////////////////////player 1st card/////////////////////////////////////////////
          
         // this.pileService.addCardToPile(this.deckID, "player",playerCardValue )//adding first player card to player pile
          console.log(playerSingleCard)
          console.log(this.playerSingleCardImage)
          let dealerSingleCard = this.allCards[3]           //dealer second card
          console.log(dealerSingleCard)
          let dealerSingleCardValues = Object.values(dealerSingleCard)          //values array of dealers second card
          let dealerCardValue=(Object.values(dealerSingleCardValues))[0]//code value of dealer 2nd card
         
          this.dealerSingleCardImage=dealerSingleCardValues[1]  //saving second dealer card img

    //      this.pileService.addCardToPile(this.deckID, "dealer",dealerCardValue)
      //    console.log(dealerSingleCard)
        //  console.log(this.dealerSingleCardImage)

//          let hahahahah3 = this.pileService.getDealerPile(this.deckID)
 //         console.log(hahahahah3)

/////////////////////////////////////////////dealers 1st card/////////////////////////////////////////////////////////////


          let playerSingleCard2 = this.allCards[2]       //players second card (JSON OBJ)
          console.log(playerSingleCard2)
          let playerSingleCardValues2 = Object.values(playerSingleCard2)      //values of players second card
          let playerCardValue2=(Object.values(playerSingleCardValues2))[0]    //first value of the 2nd card (code)
          //code player card sent to player pile
          console.log(playerCardValue2)
          this.playerSingleCardImage2=playerSingleCardValues2[1]              //save img url of second card
          //console.log(playerSingleCard)
   //       this.pileService.addCardToPile(this.deckID, "player",playerCardValue2)
          //this.playerSingleCard1 
     //     let hahahahah2 = this.pileService.getPlayerPile(this.deckID)
       //   console.log(hahahahah2)
         
          
          ///////////////////////////////////////////////2nd PlayerCard///////////////////////////////////////////
         
          
          
            


          //dealer deal cards
          let dealerSingleCard2 = this.allCards[1]              //dealr second card OBJ
          console.log(dealerSingleCard2)
          let dealerSingleCardValues2 = Object.values(dealerSingleCard2)  //value array of dealers second card
          let dealerCardValue2=(Object.values(dealerSingleCardValues2))[0]///code of dealer 2nd card
          this.dealerSingleCardImage2=dealerSingleCardValues2[1]          ////saving img of dealer card
           
          console.log("************************************************************")
          this.sendBackEndInfo()  
        }
      }
       
   
              //same with the dealer array
          ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          
         console.log(this.playerHand)
          let playerSingleCard:any = this.allCards[0]      //players first card OBJ
          console.log(playerSingleCard)
          let playerSingleCardValues = Object.values(playerSingleCard)
          console.log(playerSingleCardValues)        //value array of player 1st card OBJ
          let playerCardValue=(Object.values(playerSingleCardValues))[0]        //values of players 1st card
         
          console.log(playerCardValue)//code player card
          this.playerSingleCardImage=playerSingleCardValues[1]          //adding first player card img
          
         // this.pileService.addCardToPile(this.deckID, "player",playerCardValue )//adding first player card to player pile
          console.log(playerSingleCard)
          console.log(this.playerSingleCardImage)
          //let hahahahah = this.pileService.getPlayerPile(this.deckID)
          //console.log(hahahahah)
          

          /////////////////////////////////1st player card///////////////////////////////




          
          //console.log(playerSingleCard)
         // console.log(this.dealerSingleCardImage2)                         
          //this.playerSingleCard1 
         
          
         ///adding first dealr card to dealer pile
          //this.pileService.addCardToPile(this.deckID, "dealer",dealerCardValue2)
          //let hahahahah5 = this.pileService.getDealerPile(this.deckID)
          //console.log(hahahahah5)
          
          ////////////////////////////////////////////////////////////////////////dealer 2nd card 
          
          //adding second card to dealer pile
                //saving playing comp deckID to deck service deck id
          
          
         
        /*  Http.open("POST", this.serverURLbase + "game/start")
          Http.send()
          Http.onreadystatechange = (e) => {  
            if (Http.readyState ==4){   
              fullObject

                }
         
           let sentDealerPile=this.pileService.getDealerPile(this.deckID) //saving pile from API for dealer
 
          
             let sentPlayerPile=this.pileService.getPlayerPile(this.deckID)//saving sent player pile from API
          
          
          console.log(sentDealerPile)

          //send both piles to the back end((String JWT, int bet, String deck_id, Card[] playerHand, Card[] dealerHand))
         // this.pileService.sendPile(sentDealerPile, false)  //sending pile with update info back to API
          //this.pileService.sendPile(sentPlayerPile,true)  //sending pile back to api with updated info 
        }
        }
      }   
        
      
    // getDeck(bet2:number){
      

      /*class fullObject {
          constructor (private bet:number,private playerHand:string[], private dealerHand:string[], private deck_id:string){ //object to be sent to the back end
             this.bet = bet
             this.playerHand = playerHand
             this.dealerHand = dealerHand
             this.deck_id = deck_id
          }
      }*/
      
        
      
  
    }


      
sendBackEndInfo():any{
  class fullObject {
    constructor (private JWTtoken:string, private bet:number,private deck_id:string, private playerHand:String[], private dealerHand:String[]){ //object to be sent to the back end
      this.JWTtoken = JWTtoken 
      this.bet = bet
      this.deck_id = deck_id
      this.playerHand = playerHand
      this.dealerHand = dealerHand
       
       }

  }
  const Http = new XMLHttpRequest();  
  let backEndInfo = new fullObject(this.JWTToken, this.bet , this.deckID, this.playerHand, this.dealerHand)
  console.log(backEndInfo)
      let newGameRequest = JSON.stringify(backEndInfo);
      Http.open("POST", this.serverURLbase + "game/start")
      console.log(newGameRequest)
      Http.send(newGameRequest)
      Http.onreadystatechange=(e)=>{
        if (Http.readyState == 4){
          console.log("success")
          let responseJSON = Http.responseText;
          let response = JSON.parse(responseJSON);
          console.log(response)


        }
      }
}      
 


  hit():void{
    this.deckService.getCard()
    console.log(this.deckService.deckID)
   // this.pileService.addCardToPile(this.deckService.deckID, 'player', this.deckService.cardCode)
   // let newPile= this.pileService.getPlayerPile(this.deckService.deckID)
   // let updatedPile=this.pileService.sendPile(newPile, true)
   // Object.assign(this.iGame,updatedPile)


    }
    stay():void{

    }

    dd(){

    }
updateView(){
  /*playertotal
    dealertotal
    gameState(int)
    isplayersturn
    playercanDD
    playerhasblackjack
    dealerisbust
    */
   /*playertotal -> display a value (DAN MAKE THIS FIELDDD) ((done))
   Dealertotal _>(ALSO MAKE THIS FIELD) ((done))
   gamestate - 0 -on going   ---when game state is !0 the exit button is visable 
            - 1 - player wins (display win message !!not including blackjack!!)
            - 2 - player lose by busting (display bust message)                         add play again button on endgame screen 
            - 3 - deal wins by higher total (normal loss screen !!need blackjack!!
            - 4 - push (push with small explination of what a push is)
              when GS is not 0 the dealer stops drawing
    isplayers turn = true (all buttons visible && game state is 0, vanish when false)
                    = flase && gamestate is 0 (dealer drawns card)
    --when game is done is players turn stays flase
  playercanDD = true (button shows)
  playerHasBlackJack = true (message displayed)
  dealerBust = true (bust message is shown)*/


    if(this.iGame.isPlayersTurn && this.iGame.gameState == 0){
        //where player can draw/ hit stand player buttons avail.
        //update player hand values
       


        if(this.iGame.playerHasDoubledDown){  //dd button showtoggle
          this.ddCollapse=false;
        }
        //seperate condition for DD
    } else {

      this.hitStayButtonCollapse=false
      if(this.iGame.playerHasDoubledDown){        //this block eliminates all player input buttons when turn ends
        this.ddCollapse = false
      }
      switch(this.iGame.gameState){
        case 0: //dealer turn
          //update dealer hand vlaues
            
          
          
          //this is where dealer draws
          // player buttons no longer visible
          break;
        case 1: //player wins
          this.displayMessage = "You Won!"

         if (this.iGame.playerTotal=21){    //if player has black jack display "black jack message"
           this.displayMessage = "You Won with BlackJack!"
         }

          //dealer stops drawing
          
          break;
        case 2:
          this.displayMessage = "You Busted!"
       
          //dealer stops drawing
          
          break;
         
        case 3:
          this.displayMessage = "You Lost!"


          if(this.iGame.dealerTotal=21){//if dealer total is 21, show dealer blackjack message
            this.displayMessage="You Lost! Dealer BlackJack!"
          }
           
           //dealer stops drawing 
          break;
    
        case 4:
          this.displayMessage ="Push! "+ this.pushMessage
          //dealer stops drawing
          break;
      }
    }    



 


}
}
