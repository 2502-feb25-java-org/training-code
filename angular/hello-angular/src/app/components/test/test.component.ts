import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../../models/user.model';


@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

users: User[];
 API_URL = 'http://localhost:8085/hello-servlets/users';

httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json' } )
};


  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.loadUsers();
  }

  private handleError(error: Response) {
    return Observable.throw(error.statusText);
}


  getUserHttp(): Observable<User[]> {
    return this.http.get<User[]>(this.API_URL, this.httpOptions);
  }

  loadUsers(): void {
    this.getUserHttp().subscribe(
      list => {
        if(list!=null){
          this.users = list;
          console.log(this.users);
          console.log(this.users[0].username);
        }
        else{
          console.log('empty users list');
        }
      },
      error => console.log('error')
    );
  }

}
