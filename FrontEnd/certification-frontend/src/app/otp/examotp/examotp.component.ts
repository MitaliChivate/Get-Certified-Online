import { Component, OnInit } from '@angular/core';
import { PaymentExam } from 'src/app/models/paymentexam.model';
import { User } from 'src/app/models/user.model';
import { ActivatedRoute, Router } from '@angular/router';
import { PaymentService } from 'src/app/services/payment.service';
import { DummyPayment } from 'src/app/models/dummyexampayment.model';
import { invalid } from '@angular/compiler/src/render3/view/util';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-examotp',
  templateUrl: './examotp.component.html',
  styleUrls: ['./examotp.component.css']
})
export class ExamotpComponent implements OnInit {

  user : User;
  paymentExam : PaymentExam;
  dummy : DummyPayment;
  otp:number;
  paymentExam1 : PaymentExam;
  msg:string;

  constructor(private route : ActivatedRoute, private pService : PaymentService,private router : Router,private snackBar : MatSnackBar) { 
this.dummy=new DummyPayment();
    this.dummy=this.pService.getDummyObject();
    console.log(this.dummy)
  }

  ngOnInit(): void {
    this.user=new User();
    this.paymentExam=new PaymentExam();
    this.paymentExam1=new PaymentExam();
    this.paymentExam= this.pService.getSharedExamPaymentObject()
  console.log(this.paymentExam)

this.paymentExam1=this.paymentExam;
this.paymentExam1.cardNumber=this.dummy.cardNumber;
this.paymentExam1.cvv=this.dummy.cvv;
this.paymentExam1.expMonth=this.dummy.expMonth;
this.paymentExam1.expYear=this.dummy.expYear;
this.paymentExam1.paymentMode=this.dummy.paymentMode;

console.log(this.paymentExam1);

console.log(this.paymentExam1.userId);



  }

  submitOtp(){
    this.otp=this.user.otp;
    this.pService.makePaymentForExam(this.paymentExam1,this.otp).subscribe(response => {
      //   this.isadded = true
      this.router.navigate(['navbaruser/spinner',this.paymentExam1.amount]);
    },error=>{
      this.msg="Invalid OTP!";
      console.log("invalidOTP")
    }
    
    
    );



  }

  resendOtp(){
    console.log(this.paymentExam1.userId)
    this.pService.generateOTP(this.paymentExam1.userId).subscribe(
      data=>{
        console.log(data);
      },error=>{
        
      }

    );
  }
}
