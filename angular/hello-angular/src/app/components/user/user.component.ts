import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  test: string;
  constructor(private uService: UserService) { 
    console.log('in USER component constructor. instantiating userservice');
    console.log(uService.name);
  }

  ngOnInit() {
    console.log('in USER component ngOnInit');
    this.test = this.uService.test();
  }

 


}
