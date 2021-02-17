import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PaymentTraining } from '../models/paymenttraining.model';
import { Observable} from 'rxjs';
import { PaymentExam } from '../models/paymentexam.model';
import { DummyPayment } from '../models/dummyexampayment.model';
import { AuthenticateService } from './authenticate.service';




@Injectable({
  providedIn: 'root'
})

export class PaymentService {
  userId: Number;
  dummyObject : DummyPayment;
  paymentExam : PaymentExam;
  paymentCourse : PaymentTraining;
  constructor(private http: HttpClient, private auth : AuthenticateService) { }

  makePaymentForTraining(payment: PaymentTraining, otp :number): Observable<Object> {
    return this.http.post("http://localhost:9500/Payment/makePaymentForTraining/"+otp, payment);
  }

  makePaymentForExam(payment: PaymentExam,otp:number): Observable<Object> {
    return this.http.post("http://localhost:9500/Payment/makePaymentForExam/"+otp, payment);
  }

  getExamPaymentByUserId(userId: number) {
     console.log(userId)
    return this.http.get<PaymentExam[]>("http://localhost:9500/Payment/searchPaymentExamHistoryByUserId/"+userId);
  }

  getTrainingPaymentByUserId(userId: number) {
    console.log(userId)
    return this.http.get<PaymentTraining[]>("http://localhost:9500/Payment/searchTrainingPaymentByUserId/"+userId);
  }

  checkAlreadyEnrolledExam(id : number){
    
    this.userId=Number(this.auth.fetchFromSessionStorage()?.userId);

    return this.http.get<number>("http://localhost:9500/Payment/checkExamEnrolled/"+id+"/"+this.userId);
 
  }

  checkAlreadyEnrolledCourse(id : number){
    this.userId=Number(this.auth.fetchFromSessionStorage()?.userId);

    return this.http.get<number>("http://localhost:9500/Payment/checkTrainingEnrolled/"+id+"/"+this.userId);
 
  }

  getAllTrainingPayments() {
    return this.http.get<PaymentTraining[]>("http://localhost:9500/Payment/getAllTrainingPayments");
  }

  getAllExamPayments() {
    return this.http.get<PaymentExam[]>("http://localhost:9500/Payment/getAllExamPayments");
  }

  getAmountExam() {
    return this.http.get<number>("http://localhost:9500/Payment/getAmountExam");
  }
  getAmountTraining() {
    return this.http.get<number>("http://localhost:9500/Payment/getAmountTraining");
  }

  shareExamPaymentObject(paymentExamObject: PaymentExam) {
   
    this.paymentExam=paymentExamObject;
  }

  getSharedExamPaymentObject(){
    return this.paymentExam;
  }
  shareCoursePaymentObject(paymentCourseObject: PaymentTraining) {
   
    this.paymentCourse=paymentCourseObject;
  }

  getSharedCoursePaymentObject(){
    return this.paymentCourse;
  }

  saveDummyObject(dummy : DummyPayment){
    this.dummyObject=dummy;
  }
  getDummyObject(){
    return this.dummyObject;
  }

  generateOTP(id :number){

    return this.http.get<number>("http://localhost:9500/Payment/generateOtp/"+id);
 
  }

  checkAvailableSeats(id : number){

    return this.http.get<number>("http://localhost:9500/Payment/checkAvailableSeats/"+id);
  }
}
