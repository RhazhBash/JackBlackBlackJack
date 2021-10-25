import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GameplayviewComponent } from './gameplayview/gameplayview.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { RulesPopUpComponent } from './rules-pop-up/rules-pop-up.component';
import { PregameViewComponent } from './pregame-view/pregame-view.component';
import { AccountComponent } from './account/account.component';
import { AccountViewComponent } from './account-view/account-view.component';

const routes: Routes = [
  {path:'', component: PregameViewComponent},
  {path:'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'gameplay', component: GameplayviewComponent},
  {path: 'preGame', component: PregameViewComponent},
  {path: 'acctChange', component: AccountComponent},
  {path: 'account', component: AccountViewComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
