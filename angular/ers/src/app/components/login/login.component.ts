import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  message: string;

  constructor() { }

  ngOnInit() {
  }

  checkIfEmpty(str: string){
    if(str.length == 0 || str == null){
      this.message='Please do not leave fields blank!';
    }
    else{
      this.message='';
    }
  }

  login(){
    
  }

}
