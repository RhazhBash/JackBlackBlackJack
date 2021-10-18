import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { theDeck } from './deck';

@Injectable({
  providedIn: 'root'
})
export class DeckService {
  private url: string = "http://deckofcardsapi.com/api/deck/new/draw/?count=4"
  constructor(private http: HttpClient) { }
  
  getDeck(): Observable<theDeck[]>{
    return this.http.get<theDeck[]>(this.url);
  }
}
