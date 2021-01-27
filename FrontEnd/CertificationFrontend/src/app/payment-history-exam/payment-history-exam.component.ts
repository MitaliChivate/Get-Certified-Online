import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Exam } from '../models/exam.model';
import { PaymentExam } from '../models/paymentexam.model';
import { ExamserviceService } from '../service/examservice.service';
import { PaymentserviceService } from '../service/paymentservice.service';

@Component({
  selector: 'app-payment-history-exam',
  templateUrl: './payment-history-exam.component.html',
  styleUrls: ['./payment-history-exam.component.css']
})
export class PaymentHistoryExamComponent implements OnInit {

  payments: PaymentExam[] = [];
  payments1: PaymentExam[]=[];
  payment : PaymentExam;

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
    this.pService.getExamPaymentByUserId(this.userId).subscribe(
      (data => {
        this.payments = data;
        this.payments1 = data;
        this.isLoading = false;
      }

      )
    )
  }

  getPaymentDetailsById(userId: number) {
    this.pService.getExamPaymentByUserId(userId).subscribe((res) => {
      this.payments = res
      this.payments1 = res;
    })

  }

  onKey(event: any) {

    this.payments1 = this.payments.filter(payment => payment.exam.examName.includes(event.target.value))
    if (event.target.value == '' || event.target.value == undefined)
      this.payments1 = this.payments
  }

  logout() {
    sessionStorage.clear();
    this.route.navigate(['login']);
  }

}
