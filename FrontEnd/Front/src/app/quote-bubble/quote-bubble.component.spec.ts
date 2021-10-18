import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuoteBubbleComponent } from './quote-bubble.component';

describe('QuoteBubbleComponent', () => {
  let component: QuoteBubbleComponent;
  let fixture: ComponentFixture<QuoteBubbleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuoteBubbleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(QuoteBubbleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});