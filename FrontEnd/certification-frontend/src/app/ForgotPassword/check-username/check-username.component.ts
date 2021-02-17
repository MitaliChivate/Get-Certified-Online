import { Component, OnInit } from '@angular/core';

import { RegisterService } from 'src/app/services/register.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-check-username',
  templateUrl: './check-username.component.html',
  styleUrls: ['./check-username.component.css']
})
export class CheckUsernameComponent implements OnInit {

  user : User;
  userName : String;
  id
  constructor(private service : RegisterService,private snackBar: MatSnackBar,private router : Router, private route : ActivatedRoute) { }

  ngOnInit(): void {
    this.user=new User();
    sessionStorage.removeItem("answer")
    sessionStorage.removeItem("name")
  }

  submitUsername(){

    this.service.checkUserName(this.user.userName).subscribe(
      data=>{
console.log("username found")
        this.id=data;
        sessionStorage.setItem("name",this.user.userName)
        sessionStorage.setItem("id",this.id);
        this.router.navigate(['/securityanswer',this.id]);
      },error=>
      { this.snackBar.open('Username does not exist! ','',{duration:4000,verticalPosition:'top',panelClass:'my-custom-snackbar'})
        
      }

    )

  }
}
