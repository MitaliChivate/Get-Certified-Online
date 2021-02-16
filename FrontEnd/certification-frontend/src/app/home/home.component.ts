import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../services/authenticate.service';
import { PaymentService } from '../services/payment.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  user: boolean;
  num :number;
  constructor(private auth : AuthenticateService,private pService : PaymentService,private router : Router,private snackBar : MatSnackBar) { }

  ngOnInit(): void {

    if(this.auth.typeOfUser()=="admin")
    this.user=false;
    else
    this.user=true;


  }
  routerPaymentCourse(id : number){
    console.log(id)
    this.pService.checkAlreadyEnrolledCourse(id).subscribe(
      data=>{
        this.num=data;
        console.log(this.num)
        if(this.num==0)
        this.router.navigate(['/navbaruser/coursepayment',id]);
        else
        this.snackBar.open('You have already enrolled for this course! ','',{duration:2000,verticalPosition:'top',panelClass:'my-custom-snackbar'})
                 
      },
      error=>{
        this.snackBar.open('Error Occured! ','',{duration:2000,verticalPosition:'top',panelClass:'my-custom-snackbar'})
      
      }
      )  
  }

  routerPaymentExam(id : number){
    console.log(id)
    this.pService.checkAlreadyEnrolledExam(id).subscribe(
      data=>{
        this.num=data;
        console.log(this.num)
        if(this.num==0)
        this.router.navigate(['/navbaruser/exampayment',id]);
        else
        this.snackBar.open('You have already enrolled for this Exam! ','',{duration:2000,verticalPosition:'top',panelClass:'my-custom-snackbar'})
                 
      },
      error=>{
        this.snackBar.open('Error Occured! ','',{duration:2000,verticalPosition:'top',panelClass:'my-custom-snackbar'})
      
      }
      )  
  }
}
