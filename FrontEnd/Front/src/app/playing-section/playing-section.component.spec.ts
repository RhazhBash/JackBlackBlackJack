import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayingSectionComponent } from './playing-section.component';

describe('PlayingSectionComponent', () => {
  let component: PlayingSectionComponent;
  let fixture: ComponentFixture<PlayingSectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayingSectionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayingSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
