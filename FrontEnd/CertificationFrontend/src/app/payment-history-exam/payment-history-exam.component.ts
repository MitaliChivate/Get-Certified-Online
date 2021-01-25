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

  payment: PaymentExam[] = [];
  payments: PaymentExam;
  exams: Exam[] = [];
  exam: Exam;
  exam1: Exam[] = [];

  //Flags required for interactive UI
  userId: number;
  paymentMode: string;
  paymentDate: Date;
  amount: number;
  examName:string;

  constructor(private route: Router, private pService: PaymentserviceService) { }

  ngOnInit(): void {
    this.payment = []


    setTimeout(() => { this.reloadData() }, 100);
  }

  reloadData() {
    this.pService.getExamPaymentByUserId(this.userId).subscribe(
      (data => {
        this.payment = data;
      }

      )
    )
  }

  getPaymentDetailsById(userId: number) {
   // console.log(userId)

    this.pService.getExamPaymentByUserId(userId).subscribe((res) => {
      this.payment = res;
    })

  }

  logout() {
    sessionStorage.clear();
    this.route.navigate(['login']);
  }

}
