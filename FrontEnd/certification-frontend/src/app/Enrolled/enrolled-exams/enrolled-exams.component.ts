import { Component, OnInit } from '@angular/core';
import { PaymentExam } from 'src/app/models/paymentexam.model';
import { Exam } from 'src/app/models/exam.model';
import { Router } from '@angular/router';
import { PaymentService } from 'src/app/services/payment.service';
import { AuthenticateService } from 'src/app/services/authenticate.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ExamService } from 'src/app/services/exam.service';

@Component({
  selector: 'app-enrolled-exams',
  templateUrl: './enrolled-exams.component.html',
  styleUrls: ['./enrolled-exams.component.css']
})
export class EnrolledExamsComponent implements OnInit {

 
  payment: PaymentExam[] = [];
  payments: PaymentExam;
  exams: Exam[] = [];
  exam: Exam;
  exam1: Exam[] = [];
  bucketSize: number=5;
  p: number ;
  isLoading: boolean = true


  userId: number;
  paymentMode: string;
  paymentDate: Date;
  amount: number;
  examName:string;
  constructor(private route: Router, private pService: PaymentService,private auth: AuthenticateService,private snackBar:MatSnackBar,private service : ExamService) { }

  ngOnInit(): void {
    this.payment = []
this.userId=Number(this.auth.fetchFromSessionStorage()?.userId);

    setTimeout(() => { this.reloadData() }, 100);
  }
  reloadData() {
    this.pService.getExamPaymentByUserId(this.userId).subscribe(
      data => {
        this.payment = data;
        this.isLoading=false;
      },error=>{
        this.isLoading=false;
        this.snackBar.open("You haven't enrolled for any Exam!",'',{duration:2000,verticalPosition:'top'})
         
      }

      )
    
  }

  getPaymentDetailsById(userId: number) {
    // console.log(userId)
 
     this.pService.getExamPaymentByUserId(userId).subscribe((res) => {
       this.payment = res;
     })
 
   }

   getReminder(exam1 : Exam){

    console.log(exam1);
    console.log(this.userId)
    this.service.getReminder(this.userId,exam1).subscribe(
      data=>{
        this.snackBar.open("Reminder has been set!",'',{duration:2000,verticalPosition:'top',panelClass:'my-custom-snackbargreen'})
       
      }
    )

   }

}
