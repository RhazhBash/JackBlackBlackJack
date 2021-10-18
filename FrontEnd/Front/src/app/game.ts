export interface IGame{
    id:string,
    gameState:number,
    isPlayersTurn:boolean,
    gameIsPush:boolean,
    playerBet:number,
    playerChips:number,
    playerTotal:number,
    playerIsStanding:boolean,
    playerIsBust:boolean,
    playerWinning:boolean,
    playerHand:string[],
    dealerTotal:number,
    dealerIsBust:boolean,
    dealerIsStanding:boolean,
    dealerHand:string[]
}