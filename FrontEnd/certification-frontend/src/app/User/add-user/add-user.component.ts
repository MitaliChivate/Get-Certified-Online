import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  user = new User();
  constructor(private service : UserService ,private snackBar:MatSnackBar, public router : Router) { }

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
                this.router.navigate(['navbar/viewuser']);
                    
            
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
