import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CardComponent } from '../card/card/card.component';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  form!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient
    ) { 
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      name:'',
      username:'',
      password:'',
      cardnumber:'',
      securitycode:'',
      dob:''
    })
  }

  submit(): void {
    this.http.post('http://localhost:8090/register', this.form.getRawValue())
      .subscribe(res => {
      })
  }
}
