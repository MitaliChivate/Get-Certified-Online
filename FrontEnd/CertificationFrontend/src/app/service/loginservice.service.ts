import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../models/login.model';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  constructor(private http: HttpClient) { }

  login_url = "http://localhost:9100/authentication/login";
  registration_url = "http://localhost:9200/user/addUser";
  getUser_url = "http://localhost:9200/user/searchUser/"
  updateUser_url = "";

  public loginUser(login: Login) {
    return this.http.post<User>(this.login_url, login)
  }

  public registerUser(user: User): Observable<any> {
    return this.http.post<any>(this.registration_url, user)
  }


  public getUserByUserId(userId: string) {
    return this.http.get<User>(this.getUser_url + userId);
  }

  updateUser(user: User, userId: string) {
    return this.http.put<User>(this.updateUser_url+userId, user);
  }
}
