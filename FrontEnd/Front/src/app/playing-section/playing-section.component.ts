import { Component, OnInit } from '@angular/core';
import { CardComponent } from '../card/card/card.component';
import { DeckService } from '../deck.service';
import { PileService } from '../pile.service';
import {IGame} from '../../app/game'
import { isDelegatedFactoryMetadata } from '@angular/compiler/src/render3/r3_factory';


@Component({
  selector: 'app-playing-section',
  templateUrl: './playing-section.component.html',
  styleUrls: ['./playing-section.component.css']
})
export class PlayingSectionComponent implements OnInit {
    iGame:IGame;
    public displayMessage:string=''
    public pushMessage:string='No one wins and you get your chips back.'
  constructor(public cardService:CardComponent, public pileService:PileService, public deckService:DeckService, public IGame:IGame) {
    this.iGame=<IGame>{};
   }

  ngOnInit(): void {
  }



  hit():void{
    this.deckService.getCard()
    this.pileService.addCardToPile(this.deckService.deckID, 'player', this.deckService.cardValue)
    let newPile= this.pileService.getPlayerPile(this.deckService.deckID)
    let updatedPile=this.pileService.sendPile(newPile, true)
    Object.assign(this.iGame,updatedPile)


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

    } else {
      switch(this.iGame.gameState){
        case 0:
          // player buttons no longer visible
          break;
        case 1:
          this.displayMessage = "You Won!"
          //dealer stops drawing
          break;
        case 2:
          this.displayMessage = "You Busted!"
          //dealer stops drawing
          break;
         
        case 3:
          this.displayMessage = "You Lost!"
           //if dealer total is 21, show dealer blackjack message
           //dealer stops drawing 
          break;
    
        case 4:
          this.displayMessage ="Push!"+ this.pushMessage
          //dealer stops drawing
          break;
      }
    }    



 


}
}
