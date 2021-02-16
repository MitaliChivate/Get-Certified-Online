import { Component, OnInit } from '@angular/core';
import { PaymentExam } from 'src/app/models/paymentexam.model';
import { Exam } from 'src/app/models/exam.model';
import { Router } from '@angular/router';
import { PaymentService } from 'src/app/services/payment.service';
import { AuthenticateService } from 'src/app/services/authenticate.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-payment-history-exam',
  templateUrl: './payment-history-exam.component.html',
  styleUrls: ['./payment-history-exam.component.css']
})
export class PaymentHistoryExamComponent implements OnInit {


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
  constructor(private route: Router, private pService: PaymentService,private auth: AuthenticateService,private snackBar:MatSnackBar) { }

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
        this.snackBar.open('No Records Found!','',{duration:2000,verticalPosition:'top'})
         
      }

      )
    
  }

  getPaymentDetailsById(userId: number) {
    // console.log(userId)
 
     this.pService.getExamPaymentByUserId(userId).subscribe((res) => {
       this.payment = res;
     })
 
   }

}
