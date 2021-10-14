import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { QuoteBubbleComponent } from './quote-bubble/quote-bubble.component';
import { RulesPopUpComponent } from './rules-pop-up/rules-pop-up.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    QuoteBubbleComponent,
    RulesPopUpComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
