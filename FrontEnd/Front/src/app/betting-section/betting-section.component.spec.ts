import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BettingSectionComponent } from './betting-section.component';

describe('BettingSectionComponent', () => {
  let component: BettingSectionComponent;
  let fixture: ComponentFixture<BettingSectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BettingSectionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BettingSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
