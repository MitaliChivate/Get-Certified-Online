import { Component, OnInit } from '@angular/core';
import { t } from '@angular/core/src/render3';
import { ActivatedRoute, Router } from '@angular/router';
import { PaymentTraining } from '../models/paymenttraining.model';
import { Training } from '../models/training.model';
import { PaymentserviceService } from '../service/paymentservice.service';
import { TrainingserviceService } from '../service/trainingservice.service';

@Component({
  selector: 'app-payment-training',
  templateUrl: './payment-training.component.html',
  styleUrls: ['./payment-training.component.css']
})
export class PaymentTrainingComponent implements OnInit {

  paymentTraining:PaymentTraining;
  training:Training;
  trainingProgramId:number;
  paymentDate:Date;
  isadded: boolean = false
  constructor(private router:Router,private service:TrainingserviceService,private pService:PaymentserviceService,private route:ActivatedRoute) {
    this.paymentTraining=new PaymentTraining();
   }


  ngOnInit() {
    this.route.params.subscribe(x=>this.trainingProgramId=x['trainingProgramId']);
    if(this.trainingProgramId){
      this.service.fetchTrainingByTrainingId(this.trainingProgramId).subscribe(data=>{
        this.training=data;
        console.log(data);
      })
    }
  }

  savePayment() {
    //console.log(this.paymentTraining.training.trainingCourse);
    this.paymentTraining.userId=Number(sessionStorage.getItem('custId'));
    this.paymentTraining.training=this.training;
    this.paymentTraining.amount=this.training.trainingCost;
    console.log(this.paymentTraining.paymentMode);
    this.pService.makePaymentForTraining(this.paymentTraining).subscribe(response => {
      this.isadded = true
    });
  }

}
