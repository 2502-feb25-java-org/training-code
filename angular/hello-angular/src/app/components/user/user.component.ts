import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from '../../models/user.model';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users: User[];
  test: string;
  username: string;
  password: string;
  bio: string;
  constructor(private uService: UserService) {
    console.log('in USER component constructor. instantiating userservice');
    console.log(uService.name);
  }

  ngOnInit() {
    console.log('in USER component ngOnInit');
    this.test = this.uService.test();
    this.loadUsers();
  }

  /*
  This method will SUBSCRIBE to the observable returned 
  from our user service's getUsers() method
  */
  loadUsers() {
    this.uService.getUsers().subscribe(
      myRespBody => {
        if (myRespBody != null && myRespBody.length > 0) {
          //i know i have received some users
          this.users = myRespBody;
          console.log('yay! We have successfully received an HTTP response');
        }
        else {
          console.log('user list not populated');
        }
      },
      error => console.log('ERR')
    );
  }

  addUser(){
    let temp = new User();
    temp.username = this.username;
    temp.password = this.password;
    temp.bio = this.bio;
    this.uService.addUser(temp).subscribe(
      u => {
        console.log(u);
      },
      error => console.log('ERR')
    ); //still must subscribe to observable
  }




}
