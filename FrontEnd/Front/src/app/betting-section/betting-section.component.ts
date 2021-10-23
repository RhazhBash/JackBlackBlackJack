import { Component, Injectable, Input, OnInit } from '@angular/core';
import { TransferService } from '../services/game-bet.service';

@Component({
  selector: 'app-betting-section',
  templateUrl: './betting-section.component.html',
  styleUrls: ['./betting-section.component.css'],
  //providers: [TransferService]
})
export class BettingSectionComponent implements OnInit {

  pot:number=0
  
  bank:number = 1000
  constructor(public transferService:TransferService) { }

  ngOnInit(): void {
  }
  addChipsToBet(num:number){
      this.pot += num; 
      this.transferService.setBet(this.pot)
      this.changeBank(num);
  }
  changeBank(num:number){
    this.bank -= num;
  }

    

    
  }
  
