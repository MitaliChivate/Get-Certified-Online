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
  training:Training;
  //Flags required for interactive UI
  userId: number;
  paymentMode: string;
  paymentDate: Date;
  amount: number;
  examName:string;

  constructor(private route: Router, private pService: PaymentserviceService) { }

  ngOnInit(): void {
    this.payments = []


    setTimeout(() => { this.reloadData() }, 100);
  }

  reloadData() {
    this.pService.getTrainingPaymentByUserId(this.userId).subscribe(
      (data => {
        this.payments = data;
      }

      )
    )
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
