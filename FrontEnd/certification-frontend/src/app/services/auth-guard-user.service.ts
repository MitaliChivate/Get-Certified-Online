import { Injectable } from '@angular/core';
import { AuthenticateService } from './authenticate.service';
import { Router, RouterStateSnapshot, ActivatedRouteSnapshot, CanActivate } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardUserService implements CanActivate{

  constructor(public auth : AuthenticateService, public router : Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if(this.auth.isUserLoggedIn())
     { if(this.auth.typeOfUser() == "user")
      {
        
       if(route.url.toString() == "navbaruser")
          return true;
      }else{
        this.router.navigate(['/login']);
        return false;
      }
    }
    else{
      this.router.navigate(['/login']);
      return false;
    }  
  }
}
