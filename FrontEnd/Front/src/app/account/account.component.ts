import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { userAccount } from '../models/userAccount';
import { Observable } from 'rxjs';
import { IGame } from '../game';
import { isDelegatedFactoryMetadata } from '@angular/compiler/src/render3/r3_factory';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  form!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router
    ) {}

  ngOnInit(): void {
    let account = this.getAcctInfo();

    this.form = this.formBuilder.group({
      name:account.name,
      password:account.password,
      address:account.address,
      city:account.city,
      state:account.state,
      zipcode:account.zipcode,
      creditcard:account.cardnumber,
      expirationdate:account.expirationdate,
      securitycode:account.securitycode,
      dob:account.DOB,
      email:account.email,
    })
  }

  submit(): void {
    this.http.post('http://localhost:8090/user/register', this.form.getRawValue(),{responseType: 'text'}
    ).subscribe(() => this.router.navigate(['/login']));
  }

  getAcctInfo():any{
    let response = null;
    const http = new XMLHttpRequest();
    http.open("POST", "http://localhost:8090//game/hit/dealer");
    http.send(localStorage.getItem('id_token'));
    http.onreadystatechange = () => {
      if(http.readyState==4 && http.status==200){
      let responseJSON = http.responseText;
      response = JSON.parse(responseJSON);
      }
    }
     return response;
  }

  back():void{
    this.router.navigate(['/login']);
  }
}
