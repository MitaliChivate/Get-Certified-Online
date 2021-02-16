import { Injectable } from '@angular/core';
import { User } from '../models/user.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
 

  
  service_url = "http://localhost:9100/authentication";
  
  constructor(private _http:HttpClient) { }

  public registerUser(user: User):Observable<any> {
 
    return this._http.post<any>(this.service_url+"/register",user)
  }

  public checkEmail(user: User):Observable<any> {
 
    return this._http.post<any>(this.service_url+"/checkEmail",user)
  }

  public checkMobileNo(user: User):Observable<any> {
 
    return this._http.post<any>(this.service_url+"/checkMobileNo",user)
  }

  public checkUserName(username) {
 
    return this._http.get(this.service_url +'/checkUserName/'+username)
  } 

  public findUserByUserId(userId){
    return this._http.get(this.service_url+ '/findById/'+userId)
  }
  
  public changePassword(userId , newPassword :string){
    return this._http.get(this.service_url+ '/resetPassword/'+userId +'/'+newPassword)
  }

}
