import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GameplayviewComponent } from './gameplayview/gameplayview.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { RulesPopUpComponent } from './rules-pop-up/rules-pop-up.component';
import { PregameViewComponent } from './pregame-view/pregame-view.component';
import { AccountComponent } from './account/account.component';

const routes: Routes = [
  {path:'', component: GameplayviewComponent},
  {path:'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'preGame', component: PregameViewComponent},
  {path: 'acctChange', component: AccountComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
