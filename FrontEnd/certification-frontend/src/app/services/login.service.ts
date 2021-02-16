import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient} from '@angular/common/http';
import { User } from '../models/user.model';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  

  login_url = "http://localhost:9100/authentication/login";
  
  constructor(private _http:HttpClient) { }

  public login(user: User):Observable<any> {
 
    return this._http.post<any>(this.login_url,user)
  }

 
}
