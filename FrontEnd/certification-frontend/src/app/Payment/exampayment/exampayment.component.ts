import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, NavigationExtras } from '@angular/router';
import { ExamService } from 'src/app/services/exam.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Exam } from 'src/app/models/exam.model';
import { PaymentExam } from 'src/app/models/paymentexam.model';
import { PaymentService } from 'src/app/services/payment.service';
import { AuthenticateService } from 'src/app/services/authenticate.service';
import { DummyPayment } from 'src/app/models/dummyexampayment.model';



@Component({
  selector: 'app-exampayment',
  templateUrl: './exampayment.component.html',
  styleUrls: ['./exampayment.component.css']
})
export class ExampaymentComponent implements OnInit {

  paymentExam:PaymentExam;
  exam:Exam;
  examId:number;
  date:Date;
  dummy:DummyPayment;
  
  
  isadded: boolean = false
  id: number;
  cost: number;
  
  constructor(private auth : AuthenticateService, private route: ActivatedRoute ,private router : Router,private pService : PaymentService, private service : ExamService,  private snackBar : MatSnackBar) { 
    this.paymentExam=new PaymentExam();
    this.dummy=new DummyPayment();
  }

  ngOnInit(): void {
    this.exam=new Exam();
    this.date= new Date();

    this.id=this.route.snapshot.params['id'];

    this.service.fetchById(this.id).subscribe(
      (data: Exam) => {
       
        this.exam = data;
      },
      (error) => console.log(error)
    );
  }

  savePayment(){
    
    this.paymentExam.userId=Number(this.auth.fetchFromSessionStorage()?.userId);
    this.pService.generateOTP(this.paymentExam.userId).subscribe(
      data=>{
        console.log(data);
      }

    );
    this.paymentExam.amount=this.exam.examCost;
    this.cost=this.exam.examCost;
    this.paymentExam.paymentDate=this.date;
    this.paymentExam.exam=this.exam;
  
    this.dummy.paymentMode=this.paymentExam.paymentMode;
    this.dummy.expMonth=this.paymentExam.expMonth;
    this.dummy.expYear=this.paymentExam.expYear;
    this.dummy.cardNumber=this.paymentExam.cardNumber;
    this.dummy.cvv=this.paymentExam.cvv;
    this.pService.saveDummyObject(this.dummy);

    
   
  
    // this.pService.makePaymentForExam(this.paymentExam).subscribe(response => {
    //   this.isadded = true
    // });
   // this.router.navigate(['/navbaruser/spinner',this.cost]);
   //this.pService.shareExamPaymentObject(this.paymentExam);
 
  //  let navigationExtras : NavigationExtras={

  //   queryParams:{
  //     "paymentMode":this.paymentExam.paymentMode,
  //     "paymentDate":this.paymentExam.paymentDate,
  //     "amount":this.paymentExam.amount,
  //     "userId":this.paymentExam.userId,
  //     "expMonth":this.paymentExam.expMonth,
  //     "expYear":this.paymentExam.expYear,
  //     "cardNumber":this.paymentExam.cardNumber,
  //     "cvv":this.paymentExam.cvv,
  //     "examId":this.paymentExam.exam.examId,
  //     "examDate":this.paymentExam.exam.examDate,
  //     "startTime":this.paymentExam.exam.startTime,
  //     "endTime":this.paymentExam.exam.endTime,
  //     "examName":this.paymentExam.exam.examName,
  //     "examCost":this.paymentExam.exam.examCost,
  //     "description":this.paymentExam.exam.description

  //   }
  //  };
  
   this.pService.shareExamPaymentObject(this.paymentExam);
   this.router.navigate(['/navbaruser/bouncer',this.exam.examId]);
  
  }

}
