import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { QuoteBubbleComponent } from './quote-bubble/quote-bubble.component';
import { RulesPopUpComponent } from './rules-pop-up/rules-pop-up.component';
import { GameplayviewComponent } from './gameplayview/gameplayview.component';
import { BsDropdownModule} from 'ngx-bootstrap/dropdown';
import { HttpClientModule } from '@angular/common/http';
import { PileService } from './pile.service';
import { CardComponent}  from './card/card/card.component';
import { LoginComponent } from './login/login.component';



@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    QuoteBubbleComponent,
    RulesPopUpComponent,
    GameplayviewComponent,
    CardComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BsDropdownModule.forRoot(),
    HttpClientModule
    
  ],
  providers: [
    PileService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }