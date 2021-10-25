import { Component, OnInit } from '@angular/core';
import { CardComponent } from '../card/card/card.component';
import { DeckService } from '../deck.service';
import { PileService } from '../pile.service';
import {IGame} from '../../app/game'
import { isDelegatedFactoryMetadata } from '@angular/compiler/src/render3/r3_factory';
import { BehaviorSubject, Subscription } from 'rxjs';
import { TransferService } from '../services/game-bet.service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { Router } from '@angular/router';

//import { callbackify } from 'util';

//import { stringify } from 'querystring';


@Component({
  selector: 'app-playing-section',
  templateUrl: './playing-section.component.html',
  styleUrls: ['./playing-section.component.css']
})
export class PlayingSectionComponent implements OnInit {
    iGame:IGame;
    public displayMessage:string=''
    public pushMessage:string='No one wins and you get your chips back.'
    public ddCollapse:boolean=false;
    public hitStayButtonCollapse:boolean=false;
    public subscription: Subscription = new Subscription;
    public item:any
    pot:number=0
  public gameState:any 
  public freeBoolean:boolean = false
  bank:number = 1000
  public deckID:string =''
  public playerHand:string[] =[]
  public playerSplitHand:string[]=[]
  public dealerHand:string[]=[]
  public newCard:any
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
  public response:any
  public allCardStats:any
  public dealermessage:string=''
  public cardImageArray:string[]=[]
  public cardValueArray:string[]=[]
  public cardImage:string=''
  public cardPool:string[] =[] 
 


  constructor(public cardService:CardComponent, public pileService:PileService, public deckService:DeckService, public transferService:TransferService, private router: Router) {
    this.iGame=<IGame>{};
   }

   


  ngOnInit():void {
    this.JWTToken = localStorage.getItem('id_token')
    this.bet=this.transferService.getBet()
    this.dealStart();
  }
    //this.subscription = this.deckService.cardView.subscribe(item => this.item = item)
   
    
  //this.deckService.getDeck(4)
  
  async dealStart(){
    console.log("Curtis")
    try{
    const Http = new XMLHttpRequest();                  //
      Http.open("GET", this.url + "new/draw/?count=16");   //  
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
          
          for(let i = 0; i < 12; i++){
            this.cardPool.push(this.allCards[i])
          }

          console.log(this.cardPool)
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
          console.log(dealerSingleCard2)                                                                             /////dealer card 2 discrepency
          let dealerSingleCardValues2 = Object.values(dealerSingleCard2)  //value array of dealers second card
          let dealerCardValue2=(Object.values(dealerSingleCardValues2))[0]///code of dealer 2nd card
          this.dealerSingleCardImage2=dealerSingleCardValues2[1]          ////saving img of dealer card
           
          console.log("************************************************************")
          this.sendBackEndInfo()
          this.updateView();
        }
      
        }
      }catch(e: any){
      }
    
      
      
   
              //same with the dealer array
          ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          
       
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
      
   
  //**********************************************************************end NGONINT */
  // async getCardPool(){
      // this.cardPool = await this.cardGen()
///}
 
  

      
sendBackEndInfo():any{
  class fullObject {
    constructor (private JWTtoken:string, private bet:number,private deck_id:string, private playerHand:string[], private dealerHand:string[]){ //object to be sent to the back end
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
          this.response = JSON.parse(responseJSON);
          console.log(this.response)
          this.gameState= this.response
          this.freeBoolean = true
          
        }
      }
}      
 
hit(){
  const Http = new XMLHttpRequest();
  Http.open("GET", this.url+ this.deckID+ "/draw/"+"?count=1");        //
  Http.send();                                                          //this function draws a new card from the deck api 
  Http.onreadystatechange = (e) => {    
    if (Http.readyState ==4 && Http.status==200){
      let newCard = Http.responseText                                  //
      let parsed_NewCard = JSON.parse(newCard)  
      console.log(newCard)  
      console.log(parsed_NewCard)                        //        this is to get the proper information
      let deckID= parsed_NewCard.deck_id 
      console.log(deckID)  
                                                                       //        after hittng the deal button
      this.allCardStats = parsed_NewCard.cards  //object of new card = all allCardStats
      console.log(this.allCardStats)
      this.cardValueArray = Object.values(this.allCardStats) //card by itself with cardValueArray
      console.log(this.cardValueArray)
      console.log(this.cardValue)
      console.log(this.allCardStats[0])
      let cardValueSplit = this.cardValueArray[0]
      console.log(cardValueSplit)
      this.cardValue=this.allCardStats[0].value
      let cardImage=this.allCardStats[0].image
      let cardCode=this.allCardStats[0].code
      console.log(cardCode)
      console.log(cardValueSplit)
      this.cardImageArray.push(this.cardImage)
      console.log(this.cardImageArray)
     // console.log(this.cardImage)

     // console.log(this.cardValueArray) 
    //  console.log(this.cardValueSplit)
      //console.log(this.cardValue) 
      this.sendBackEndInfo()
      this.updateView()
     
    }                                //using the deck_id from the original deck
  }
} 
   
  
  




  
    
    



    //this.updateView()
   // this.pileService.addCardToPile(this.deckService.deckID, 'player', this.deckService.cardCode)
   // let newPile= this.pileService.getPlayerPile(this.deckService.deckID)
   // let updatedPile=this.pileService.sendPile(newPile, true)
   // Object.assign(this.iGame,updatedPile)


    

 


    stay():void{

    }

    async dd(){
      this.bet *= 2;
      let packageToSend:any = {};
      packageToSend.JWT = localStorage.getItem("id_token");
      packageToSend.deckID = this.deckID;
      const http = new XMLHttpRequest();
      http.open("POST", "http://localhost:8090/game/doubledown");
      http.send(packageToSend); 
      http.onreadystatechange = (e) => {    
        if (http.readyState ==4 && http.status == 200){
          console.log("doubledown request successful");
        } else {
          console.log("doubledown request unsuccessful");
        }
      }
      this.hit();
    }

    exitGame():void{
      //send bank to back end?
      this.router.navigate(['/']) 
    }

    restartGame():void{
      this.displayMessage=''
      this.pushMessage='No one wins and you get your chips back.'
      this.ddCollapse=false;
      this.hitStayButtonCollapse=false;

      //item:any
      //gameState:any 
      this.freeBoolean = false
      this.bank = 1000
      this.deckID=""
      this.playerHand=[]
      this.dealerHand=[]
      this.newCard=""
      this.parsed_NewCard=[]
      this.parsed_Cards=''
      this.newCardCode=''
      this.cardsSubCat=[]
      this.cardValue=''
      this.preDeck=false
      //this.cardSource.asObservable();
      this.allCards=[]
      this.playerSingleCard1=''
      this.playerSingleCard2=''
      this.playerSingleCardImage=''
      this.playerSingleCardImage=''
      this.dealerSingleCard1=''
      this.dealerSingleCard2=''
      this.dealerSingleCardImage=''
      this.dealerSingleCardImage2=''
      this.bet = 0
      this.response=null;
      this.allCardStats=null;
      this.dealermessage=''
      this.cardImageArray=[]
      this.cardValueArray=[]
      this.cardImage=''
      this.cardPool=[] 
      //here we need to toggle betting section back on,
      // but the div that the deal button is in no longer exists
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


    if(this.gameState.isPlayersTurn && this.gameState.gameState == 0){
        //where player can draw/ hit stand player buttons avail.
        //update player hand values
        this.hitStayButtonCollapse=false
      if(this.playerHand.length < 3){

        if(this.gameState.playerHasDoubledDown){  //dd button showtoggle
          this.ddCollapse=true;
        } else {
          this.ddCollapse=false;
        }

      }
        //seperate condition for DD
    } else {

      this.hitStayButtonCollapse=false
      this.ddCollapse = false
      switch(this.gameState.gameState){
        case 0: //dealer turn
          //update dealer hand vlaues
          this.displayMessage="huosoaosoas"
            
          this.hit();
          
          //this is where dealer draws
          // player buttons no longer visible
          break;
        case 1: //player wins
          if(this.gameState.playerHasBlackJack){
            this.displayMessage = "You Won with BlackJack!"
          }else{
            this.displayMessage = "You Won!"
          }
          if(this.gameState.isDealerBust)
          {
            this.dealermessage = "Dealer Bust"
          }
          //dealer stops drawing
          
          break;
        case 2:
          this.displayMessage = "You Busted!"
       
          //dealer stops drawing
          
          break;
         
        case 3:
          this.displayMessage = "You Lost!"


          if(this.gameState.dealerTotal=21){//if dealer total is 21, show dealer blackjack message
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





/*console.log("*****hitting*****")
    const Http = new XMLHttpRequest();
    Http.open("GET", this.url+ this.deckID+ "/draw/?count=1");   
    console.log(Http.readyState)     //
    Http.send();     
    console.log(Http.readyState)                                                     //this function draws a new card from the deck api 
    Http.onreadystatechange = () => {  
      console.log(Http.readyState)
      console.log(Http.status)
      if (Http.readyState ==4 && Http.status==200){
        let newCard = (Http.responseText)                                   //
        let parsed_NewCard = JSON.parse(newCard)  
        console.log(newCard)  
        console.log(parsed_NewCard)                        //        this is to get the proper information
        let deckID= parsed_NewCard.deck_id 
        console.log(deckID)  
                                                                         //        after hittng the deal button
        this.deckService.allCardStats = parsed_NewCard.cards  //object of new card = all allCardStats
        console.log(this.deckService.allCardStats)
        this.deckService.cardValueArray = Object.values(this.deckService.allCardStats) //card by itself with cardValueArray
        console.log(this.deckService.cardValueArray)
        console.log(this.cardValue)
        this.deckService.cardValueSplit = this.deckService.cardValueArray[0]
        this.cardValue=this.deckService.allCardStats[0].value
        this.deckService.cardImage=this.deckService.allCardStats[0].image
        this.deckService.cardCode=this.deckService.allCardStats[0].code
        console.log(this.deckService.cardCode)
        console.log(this.deckService.cardValueSplit)
        this.deckService.cardImageArray.push(this.deckService.cardImage)
        console.log(this.deckService.cardImageArray)
    console.log(this.deckService.deckID)
    //let tempNewCard =JSON.parse(this.deckService.allCardStats)
    console.log(this.deckService.cardValueSplit)
    */
      }

function cardGen(): ((this: XMLHttpRequest, ev: Event) => any) | null {
  throw new Error('Function not implemented.');
}
