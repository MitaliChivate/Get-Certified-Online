import { Component, OnInit } from '@angular/core';

import { RegisterService } from 'src/app/services/register.service';
import { Router, ActivatedRoute } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { User } from 'src/app/models/user.model';



@Component({
  selector: 'app-security-answer',
  templateUrl: './security-answer.component.html',
  styleUrls: ['./security-answer.component.css']
})
export class SecurityAnswerComponent implements OnInit {

  user : User;
  user1 : User;
  
  id
  constructor(private service :RegisterService, private router : Router, private route: ActivatedRoute, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.user=new User;
    this.user1=new User;
    this.id=this.route.snapshot.params['id'];
    this.service.findUserByUserId(this.id ).subscribe(
      (data:User)=>{

        this.user=data;

      }

    )
    
    let name = sessionStorage.getItem("name");
    let userId= sessionStorage.getItem("id")
    if(name==null || userId!=this.id){
    this.snackBar.open('You are accessing an application in wrong way! ','',{duration:4000,verticalPosition:'top',panelClass:'my-custom-snackbar'})
        this.router.navigate(['/login']) 
    }
    



  }

  submitAnswer(){
   if( this.user.securityAnswer== this.user1.securityAnswer){
       this.router.navigate(['/resetpassword',this.id]);
       sessionStorage.setItem("answer",this.user1.securityAnswer);
      
   }
   else  this.snackBar.open('Invalid answer! ','',{duration:4000,verticalPosition:'top',panelClass:'my-custom-snackbar'})
          }
}
