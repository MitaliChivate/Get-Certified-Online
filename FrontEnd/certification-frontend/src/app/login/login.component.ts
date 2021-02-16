/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-03 23:09:09
 * @modify date 2020-11-03 23:09:09
 * @desc Login Operation
 */
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { LoadingService } from 'src/app/services/loading.service';
import { User } from '../models/user.model';
import { LoginService } from '../services/login.service';
import { AuthenticateService } from '../services/authenticate.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit, OnDestroy {
  loginForm: FormGroup;
  submitted = false;
  loginSubscription: Subscription;
  user=new User();
  userr=new User();
  msg : string;

  constructor(
    private router: Router,
    public loadingService: LoadingService,
    public loginService : LoginService,
    public auth : AuthenticateService,
    private snackBar:MatSnackBar
  ) {}


  
  ngOnDestroy(): void {
    }

  ngOnInit(): void {
    this.auth.logout();
    sessionStorage.clear();
    sessionStorage.removeItem('name');
    sessionStorage.removeItem('ans')
    sessionStorage.removeItem('id')
   
    
  }

 

  loginUser() {
     
      this.loginService.login(this.user).subscribe(
        data=>{
          console.log("response received");
          this.userr=data;
          sessionStorage.setItem("user",JSON.stringify(this.userr));
           if( this.auth.authenticate(this.userr)){
              if(this.auth.typeOfUser()=="admin")
              {this.snackBar.open('Login Successful',this.auth.typeOfUser(),{duration:2000,verticalPosition:'top',panelClass:'my-custom-snackbargreen'})
                console.log(this.auth.typeOfUser())
               this.router.navigate(['/navbar'])
              }
               if(this.userr.role=="user"){
                this.snackBar.open('Login Successful',this.auth.typeOfUser(),{duration:2000,verticalPosition:'top',panelClass:'my-custom-snackbargreen'})
               this.router.navigate(['/navbaruser'])
               }
               
       
        }else
        this.router.navigate(['/login'])
              
      
      },
        error=>{
          console.log("exception occured")
          this.msg="Bad Credentials! Please enter valid username/Password";
          this.snackBar.open('Login Failed','',{duration:2000,verticalPosition:'bottom',panelClass:'my-custom-snackbar'})
              
        })
        this.loadingService.disableLoading();
     
  }

 
}
