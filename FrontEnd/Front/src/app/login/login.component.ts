import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  form!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router,
   
    ) { 
  }

  ngOnInit(): void {

    this.form = this.formBuilder.group({
      username:'',
      password:''
    })
  }
  

  submit() {
  this.http.post('http://localhost:8090/user/login', this.form.getRawValue(),{responseType: 'text'}
  ).subscribe(() => this.router.navigate(['/']), res => this.setSession(res));
  }
  
  private setSession(authResult:any) {
  localStorage.setItem('id_token', authResult);
  }   

}




