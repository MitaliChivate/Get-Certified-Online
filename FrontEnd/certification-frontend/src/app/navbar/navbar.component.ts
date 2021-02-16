import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../services/authenticate.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

 

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

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
