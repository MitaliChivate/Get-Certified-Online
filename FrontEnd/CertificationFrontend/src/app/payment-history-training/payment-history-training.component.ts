import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PaymentTraining } from '../models/paymenttraining.model';
import { Training } from '../models/training.model';
import { PaymentTrainingComponent } from '../payment-training/payment-training.component';
import { PaymentserviceService } from '../service/paymentservice.service';

@Component({
  selector: 'app-payment-history-training',
  templateUrl: './payment-history-training.component.html',
  styleUrls: ['./payment-history-training.component.css']
})
export class PaymentHistoryTrainingComponent implements OnInit {

  payments: PaymentTraining[] = [];
  payments1: PaymentTraining[] = [];
  payment : PaymentTraining

 

  //Flags required for interactive UI
  isAdded: boolean = null
  isUpdated: boolean = false
  isLoading: boolean = true
  isErrorUpdating: boolean = false

  userId: number;
  paymentMode: string;
  paymentDate: Date;
  amount: number;
  examName:string;

  constructor(private route: Router, private pService: PaymentserviceService) { }

  ngOnInit(): void {
    this.payments = []
    this.payments1 = []

    setTimeout(() => { this.reloadData() }, 100);
  }

  reloadData() {
    this.pService.getTrainingPaymentByUserId(this.userId).subscribe(
      data => {
        this.payments = data;
        this.payments1=data;
        this.isLoading = false
      },
      err=>{
        alert("There are no payments done for Training")
        this.route.navigate(['user/dashboard']);
      }

      
    )
  }

  onKey(event: any) {

    this.payments1 = this.payments.filter(payment => payment.training.trainingCourse.includes(event.target.value))
    if (event.target.value == '' || event.target.value == undefined)
      this.payments1 = this.payments
  }

  getCoursePaymentDetailsById(userId: number) {
   // console.log(userId)

    this.pService.getTrainingPaymentByUserId(userId).subscribe((res) => {
      this.payments = res;
    })

  }

  logout() {
    sessionStorage.clear();
    this.route.navigate(['login']);
  }
}
