import { Component, OnInit } from '@angular/core';
import { PaymentTraining } from 'src/app/models/paymenttraining.model';
import { Training } from 'src/app/models/training.model';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticateService } from 'src/app/services/authenticate.service';
import { TrainingService } from 'src/app/services/training.service';
import { PaymentService } from 'src/app/services/payment.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-course-payment-received',
  templateUrl: './course-payment-received.component.html',
  styleUrls: ['./course-payment-received.component.css']
})
export class CoursePaymentReceivedComponent implements OnInit {


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
  constructor(private router:Router,private auth : AuthenticateService, private service:TrainingService,private pService:PaymentService,private route:ActivatedRoute,private snackBar:MatSnackBar) { 

  }

  ngOnInit(): void {

    this.payments = []

    this.pService.getAllTrainingPayments().subscribe(
      data=>{
        this.payments=data;
        this.isLoading= false;

      },
      error=>{
        this.isLoading= false;
        this.snackBar.open('No Payments are done!','',{duration:2000,verticalPosition:'top'})
         
      })

      this.pService.getAmountTraining().subscribe(data => {
        this.amount = data;
        this.isLoading=false;
      },
      )
 }
}