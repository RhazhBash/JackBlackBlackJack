import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BettingSectionComponent } from '../betting-section/betting-section.component';
import { PlayingSectionComponent } from '../playing-section/playing-section.component';

@Injectable({providedIn: 'root'})
export class TransferService {
  constructor(private router:Router){ }

  public bet:number = 0
  public temp:number = 0;
  public startDeal:boolean=false
  
  setBet(bet:number){
    this.bet = bet;

   }

  getBet(){
    let temp = this.bet;
    this.clearBet();
    return temp;
  }

  clearBet(){
    this.bet = 0;
  }

}