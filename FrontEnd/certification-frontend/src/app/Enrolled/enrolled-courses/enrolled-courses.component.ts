import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PaymentService } from 'src/app/services/payment.service';
import { AuthenticateService } from 'src/app/services/authenticate.service';
import { PaymentTraining } from 'src/app/models/paymenttraining.model';
import { Training } from 'src/app/models/training.model';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-enrolled-courses',
  templateUrl: './enrolled-courses.component.html',
  styleUrls: ['./enrolled-courses.component.css']
})
export class EnrolledCoursesComponent implements OnInit {

  payments: PaymentTraining[] = [];
  training:Training;
  //Flags required for interactive UI
  userId: number;
  paymentMode: string;
  paymentDate: Date;
  amount: number;
  examName:string;

  bucketSize: number=5;
  p: number ;
  isLoading: boolean = true
  constructor(private route: Router, private pService: PaymentService,private auth : AuthenticateService ,private snackBar:MatSnackBar) { }

  ngOnInit(): void {
    this.payments = []

    this.userId=Number(this.auth.fetchFromSessionStorage()?.userId)
    setTimeout(() => { this.reloadData() }, 100);
  }
  reloadData() {
    this.pService.getTrainingPaymentByUserId(this.userId).subscribe(
      data => {
        this.payments = data;
        this.isLoading=false;
      },error=>{
        this.isLoading=false;
        this.snackBar.open("You haven't enrolled for any Course!",'',{duration:2000,verticalPosition:'top'})
         
      }

      )
    
  }

  
  getCoursePaymentDetailsById(userId: number) {
    // console.log(userId)
 
     this.pService.getTrainingPaymentByUserId(userId).subscribe((res) => {
       this.payments = res;
     })
 
   }
 

}
