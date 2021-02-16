import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { PaymentTraining } from 'src/app/models/paymenttraining.model';
import { DummyPayment } from 'src/app/models/dummyexampayment.model';
import { ActivatedRoute, Router } from '@angular/router';
import { PaymentService } from 'src/app/services/payment.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-courseotp',
  templateUrl: './courseotp.component.html',
  styleUrls: ['./courseotp.component.css']
})
export class CourseotpComponent implements OnInit {

  user : User;
  paymentTraining : PaymentTraining;
  dummy : DummyPayment;
  otp:number;
  paymentTraining1 : PaymentTraining;
  msg:string;
  constructor(private route : ActivatedRoute, private pService : PaymentService,private router : Router,private snackBar : MatSnackBar) {
    this.dummy=new DummyPayment();
    this.dummy=this.pService.getDummyObject();
    console.log(this.dummy)
   }

  ngOnInit(): void {
    this.user=new User();
    this.paymentTraining=new PaymentTraining();
    this.paymentTraining1=new PaymentTraining();
    this.paymentTraining=this.pService.getSharedCoursePaymentObject();
    console.log(this.paymentTraining)

    this.paymentTraining1=this.paymentTraining;
this.paymentTraining1.cardNumber=this.dummy.cardNumber;
this.paymentTraining1.cvv=this.dummy.cvv;
this.paymentTraining1.expMonth=this.dummy.expMonth;
this.paymentTraining1.expYear=this.dummy.expYear;
this.paymentTraining1.paymentMode=this.dummy.paymentMode;

console.log(this.paymentTraining1);

console.log(this.paymentTraining1.userId);

  }

  submitOtp(){
    this.otp=this.user.otp;
    this.pService.makePaymentForTraining(this.paymentTraining1,this.otp).subscribe(response => {
      //   this.isadded = true
      this.router.navigate(['navbaruser/spinner',this.paymentTraining1.amount]);
    },error=>{
      this.msg="Invalid OTP!";
      console.log("invalidOTP")
    }
    
    
    );



  }

  resendOtp(){
    console.log(this.paymentTraining1.userId)
    this.pService.generateOTP(this.paymentTraining1.userId).subscribe(
      data=>{
        console.log(data);
      },error=>{
        
      }

    );
  }


}
