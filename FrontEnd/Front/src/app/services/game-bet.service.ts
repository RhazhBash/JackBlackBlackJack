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
  public bank:number=1000

  
  setBet(bet:number){
    this.bet = bet;

   }

  getBet(){
    let temp = this.bet;
    this.clearBet();
    return temp;
  }
  setBank(bank:number){
    this.bank = bank
  }

  getBank(){
    return this.bank
  }
  changeBank(bet:number){
    this.bank = this.bank - bet
  }

  clearBet(){
    this.bet = 0;
  }
  subtractBank(num:number){
    this.bank -= num;
  }
  addBank(num:number){
    this.bank += num;
  }

}