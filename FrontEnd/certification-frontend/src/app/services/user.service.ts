import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user.model';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class UserService {
 
  serviceUrl= "http://localhost:9200/user"

  constructor(private http : HttpClient) { }

  deleteUserRecord(id) {
    console.log(id)
    return this.http.delete(this.serviceUrl+ "/deleteUser/"+ id);
 
  }
  viewAllUsers() {
    return this.http.get(this.serviceUrl + "/getAllUser");
  }

  registerUser(user: User):Observable<any> {
 
    return this.http.post<any>(this.serviceUrl +'/addUser ',user)
  }

  fetchById(id) {
    return this.http.get(this.serviceUrl + '/searchUser/' + id);
  }

  updateUser(formData) {
    return this.http.put(this.serviceUrl + '/updateUser', formData);
  }

  public checkEmail(user: User):Observable<any> {
 
    return this.http.post<any>(this.serviceUrl+"/checkEmail",user)
  }

  public checkMobileNo(user: User):Observable<any> {
 
    return this.http.post<any>(this.serviceUrl+"/checkMobileNo",user)
  }


  
  
  

}
