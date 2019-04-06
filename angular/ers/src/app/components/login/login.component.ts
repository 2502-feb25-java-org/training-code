import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  message: string;
  users: User[];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.getUsers();
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

  getUsers(){
    this.userService.getUsers().subscribe(
      data => {
        this.users = data;
        console.log('got user data');
        console.log(data);
      },
      error => console.log('something wrong happened')
    )
  }

}
