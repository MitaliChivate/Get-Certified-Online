import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Exam } from '../models/exam.model';
import { PaymentExam } from '../models/paymentexam.model';
import { ExamserviceService } from '../service/examservice.service';
import { PaymentserviceService } from '../service/paymentservice.service';

@Component({
  selector: 'app-payment-exam',
  templateUrl: './payment-exam.component.html',
  styleUrls: ['./payment-exam.component.css']
})
export class PaymentExamComponent implements OnInit {

  paymentExam:PaymentExam;
  exam:Exam;
  examId:number;
  paymentDate:Date;
  isadded: boolean = false
  cost : number
  constructor(private router:Router,private service:ExamserviceService,private pService:PaymentserviceService,private route:ActivatedRoute) {
    this.paymentExam=new PaymentExam();
   }


  ngOnInit() {
    this.route.params.subscribe(x=>this.examId=x['examId']);
    if(this.examId){
      this.service.fetchExamByExamId(this.examId).subscribe(data=>{
        this.exam=data;
        this.cost=this.exam.examCost
        console.log(data);
      })
    }
  }

  savePayment() {
    //console.log(this.paymentTraining.training.trainingCourse);
    this.paymentExam.userId=Number(sessionStorage.getItem('custId'));
    this.paymentExam.exam=this.exam;
    this.paymentExam.amount=this.exam.examCost;
    console.log(this.paymentExam.paymentMode);
    this.pService.makePaymentForExam(this.paymentExam).subscribe(
      response => {
        this.redirectPaymentdetail()
      },
      err=>{
        alert("Payment is already Done for this exam . Please Select another exam...")
        this.router.navigate(['user/dashboard/exam/add']);
      }
       
    );
    ;
  }
 redirectPaymentdetail()
  {
    this.router.navigate(['user/dashboard/payment-confirmation']);
  }

}
