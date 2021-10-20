import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GameplayviewComponent } from './gameplayview/gameplayview.component';
import { LoginComponent } from './login/login.component';
import { RulesPopUpComponent } from './rules-pop-up/rules-pop-up.component';

const routes: Routes = [
  {path:'', component: GameplayviewComponent},
  {path:'rules', component: RulesPopUpComponent},
  {path:'login', component: LoginComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
