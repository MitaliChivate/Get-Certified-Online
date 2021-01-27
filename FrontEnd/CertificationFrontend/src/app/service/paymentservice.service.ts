import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Exam } from '../models/exam.model';
import { PaymentExam } from '../models/paymentexam.model';
import { PaymentTraining } from '../models/paymenttraining.model';

@Injectable({
  providedIn: 'root'
})
export class PaymentserviceService {

  constructor(private http: HttpClient) { }

  makePaymentForTraining(payment: PaymentTraining): Observable<Object> {
    return this.http.post("http://localhost:9500/Payment/makePaymentForTraining", payment);
  }

  makePaymentForExam(payment: PaymentExam): Observable<Object> {
    return this.http.post("http://localhost:9500/Payment/makePaymentForExam", payment);
  }

  getExamPaymentByUserId(userId: number) {
    var userId=Number(sessionStorage.getItem('custId'));
    console.log(userId)
    return this.http.get<PaymentExam[]>("http://localhost:9500/Payment/searchPaymentExamHistoryByUserId/"+userId);
  }

  getTrainingPaymentByUserId(userId: number) {
    var userId=Number(sessionStorage.getItem('custId'));
    console.log(userId)
    return this.http.get<PaymentTraining[]>("http://localhost:9500/Payment/searchTrainingPaymentByUserId/"+userId);
  }

  countPayments(){
    return this.http.get("http://localhost:9500/Payment/count");;
  }

}
