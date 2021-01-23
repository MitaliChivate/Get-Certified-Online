import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {

  updateUser(user: User) {
    return this.http.put<User>("http://localhost:9200/user/updateUser", user);
  }

  getUserByUserId(custId: string) {
    console.log(custId)
    return this.http.get<User>("http://localhost:9200/user/searchUser/"+custId);
  }

  constructor(private http: HttpClient) { }

  countUser() {
    return this.http.get("http://localhost:9200/user/count");
  }

}
