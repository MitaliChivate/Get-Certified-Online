import { Component, OnInit } from '@angular/core';
import { PaymentTraining } from 'src/app/models/paymenttraining.model';
import { Training } from 'src/app/models/training.model';
import { ActivatedRoute, Router } from '@angular/router';
import { PaymentService } from 'src/app/services/payment.service';
import { TrainingService } from 'src/app/services/training.service';
import { AuthenticateService } from 'src/app/services/authenticate.service';
import { DummyPayment } from 'src/app/models/dummyexampayment.model';

@Component({
  selector: 'app-coursepayment',
  templateUrl: './coursepayment.component.html',
  styleUrls: ['./coursepayment.component.css']
})
export class CoursepaymentComponent implements OnInit {


  paymentTraining:PaymentTraining;
  training:Training;
  trainingProgramId:number;
  paymentDate:Date;
  dummy:DummyPayment;
  isadded: boolean = false;
  id: number;
  cost: number;
  date:Date;
  constructor( private router:Router,private auth : AuthenticateService, private service:TrainingService,private pService:PaymentService,private route:ActivatedRoute) { 

    this.paymentTraining=new PaymentTraining();
    this.dummy=new DummyPayment();
  }

  ngOnInit(): void {
    this.training=new Training();
    this.date= new Date();

    this.id=this.route.snapshot.params['id'];

    this.service.fetchById(this.id).subscribe(
      (data: Training) => {
        console.log(data);
        this.training = data;
      },
      (error) => console.log(error)
    );
    
  }

  savePayment() {
    this.paymentTraining.userId=Number(this.auth.fetchFromSessionStorage()?.userId);
    this.pService.generateOTP(this.paymentTraining.userId).subscribe(
      data=>{
        console.log(data);
      }

    );
    this.paymentTraining.training=this.training;
    this.paymentTraining.amount=this.training.trainingCost;
    this.cost=this.training.trainingCost;
    this.paymentTraining.paymentDate=this.date;
 
    this.dummy.paymentMode=this.paymentTraining.paymentMode;
    this.dummy.expMonth=this.paymentTraining.expMonth;
    this.dummy.expYear=this.paymentTraining.expYear;
    this.dummy.cardNumber=this.paymentTraining.cardNumber;
    this.dummy.cvv=this.paymentTraining.cvv;
    this.pService.saveDummyObject(this.dummy);


    this.pService.shareCoursePaymentObject(this.paymentTraining);
    this.router.navigate(['/navbaruser/bouncer',this.training.trainingProgramId]);
   
    
 
  }

}
