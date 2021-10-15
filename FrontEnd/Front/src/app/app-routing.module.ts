import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RulesPopUpComponent } from './rules-pop-up/rules-pop-up.component';

const routes: Routes = [
  {
    path:"rules",
    component:RulesPopUpComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
