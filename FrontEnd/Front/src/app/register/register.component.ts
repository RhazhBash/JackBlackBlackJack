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

  constructor(private formBuilder: FormBuilder) { 
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      name:'',
      email:'',
      password:'',
      address:'',
      city:'',
      state:'',
      zipcode:'',
      dob:'',
      creditcard:'',
      securitycode:''
    })
  }

  submit(): void {
    console.log(this.form.getRawValue());
  }
}
