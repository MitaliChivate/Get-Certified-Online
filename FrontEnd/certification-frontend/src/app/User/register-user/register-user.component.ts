import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { RegisterService } from 'src/app/services/register.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {

  user = new User();
  constructor(public service : RegisterService,private snackBar:MatSnackBar, public router : Router) { }

  ngOnInit(): void {
  }

  submitForm(){

    this.service.checkEmail(this.user).subscribe(
      data=>{
        this.service.checkMobileNo(this.user).subscribe(

          data=>{

            this.service.registerUser(this.user).subscribe(
              data=>{
                console.log("response received");
                this.snackBar.open('Registration Successful','',{duration:4000,verticalPosition:'top',panelClass:'my-custom-snackbargreen'})
                this.router.navigate(['/login']);
                    
            
            },
              error=>{
                console.log("exception occured")
                this.snackBar.open('Username already exist! Try using different username.','',{duration:4000,verticalPosition:'top',panelClass:'my-custom-snackbar'})
        
                
              })

          },error=>{
            this.snackBar.open('Mobile No already registered!','',{duration:4000,verticalPosition:'top',panelClass:'my-custom-snackbar'})

          }
        )

      },error=>{
        this.snackBar.open('Email ID already registered!','',{duration:4000,verticalPosition:'top',panelClass:'my-custom-snackbar'})


      }


    )
   
      
   
}

     

  }
  

