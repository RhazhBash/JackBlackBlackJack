import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import { IPiles } from './piles';
import { IPile } from './pile';
import { ICard } from './card';
import { PileService } from './pile.service';

fdescribe('HttpDataService', ()=>{
  let httpTestController: HttpTestingController;
  let pileService: PileService;

  beforeEach(() => TestBed.configureTestingModule({
    imports: [HttpClientTestingModule],
      providers: [PileService]
  }));

  beforeEach(() => {
    pileService = TestBed.get(PileService);
    httpTestController = TestBed.get(HttpTestingController);
  });

  it('should get HttpClient.get', ()=>{
    const testPile = {
                      "success": true,
                      "deck_id": "kkadm0q70dfr",
                      "remaining": 51,
                      "piles": {
                                "player": {
                                "remaining": 1,
                                "cards": [
                                {
                                  "code": "5C",
                                  "image": "https://deckofcardsapi.com/static/img/5C.png",
                                  "images": {
                                              "svg": "https://deckofcardsapi.com/static/img/5C.svg",
                                              "png": "https://deckofcardsapi.com/static/img/5C.png"
                                            },
                                  "value": "5",
                                  "suit": "CLUBS"
                                }
                                ]
                              }
                      }
  }
                       
    pileService.getPile("zhlhs1laws6c", "newPile").subscribe((pileB)=>{
      expect(testPile).toBe(pileB, 'should check mocked data');
  });
});

/*
describe('PileService', () => {
  let service: PileService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PileService);
  });

  it('should get piles', () => {
    let serviceComp = new PileService(new HttpClient());
  });
});
*/

