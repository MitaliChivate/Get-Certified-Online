import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot, CanActivate } from '@angular/router';
import { AuthenticateService } from './authenticate.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardAdminService implements CanActivate{

  constructor(public auth : AuthenticateService, public router : Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if(this.auth.isUserLoggedIn())
    { if(this.auth.typeOfUser() == "admin")
     {
       
      if(route.url.toString() == "navbar")
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
