import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user.model';



const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  apiURL = environment.apiUrl; // take URL from environment so that if it chnages we only have to change it in one place

  constructor(private http: HttpClient) { }

  public getUsers(){
    return this.http.get<User[]>(`${this.apiURL}/user`);
  }

}
