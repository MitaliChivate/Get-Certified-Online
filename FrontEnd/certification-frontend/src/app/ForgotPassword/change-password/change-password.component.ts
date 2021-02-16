import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { RegisterService } from 'src/app/services/register.service';
import { Router, ActivatedRoute } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  user : User;
  user1: User;
  id
  constructor(private service :RegisterService, private router : Router, private route: ActivatedRoute, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.user=new User;
    this.user1=new User;
    this.id=this.route.snapshot.params['id'];
    this.service.findUserByUserId(this.id ).subscribe(
      (data:User)=>{

        this.user1=data;

      }

    )
    let ans = sessionStorage.getItem("answer")
    let name= sessionStorage.getItem("name")
    let userId= sessionStorage.getItem("id")
    console.log(userId)
    if(ans==null ||  name ==null || userId!=this.id){
      this.snackBar.open('You are accessing an application in illegal way! ','',{duration:4000,verticalPosition:'top',panelClass:'my-custom-snackbar'})
      this.router.navigate(['/login']);
    }
  


  }

  changePassword(){

    this.service.changePassword(this.id , this.user.password).subscribe(
      data=>{
        this.snackBar.open('Password has been changed successfully! ','',{duration:4000,verticalPosition:'top',panelClass:'my-custom-snackbargreen'})
   sessionStorage.clear();
        
      }
    )
    this.router.navigate(['/login']);
        

  
    
}

}
