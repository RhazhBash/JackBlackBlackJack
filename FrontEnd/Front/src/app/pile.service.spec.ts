import { TestBed } from '@angular/core/testing';

import { PileService } from './pile.service';

describe('PileService', () => {
  let service: PileService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PileService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
