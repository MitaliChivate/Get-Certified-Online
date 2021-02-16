import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../services/authenticate.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-navbaruser',
  templateUrl: './navbaruser.component.html',
  styleUrls: ['./navbaruser.component.css']
})
export class NavbaruserComponent implements OnInit {

  constructor(public auth : AuthenticateService,
    public router : Router,private snackBar : MatSnackBar) { }

ngOnInit(): void {
}

logoutUser(){
console.log("logged out")
this.auth.logout();
this.router.navigate(['/login']);
this.snackBar.open('Logged out!','',{duration:2000,panelClass:'my-custom-snackbargreen'})
   
}

}
