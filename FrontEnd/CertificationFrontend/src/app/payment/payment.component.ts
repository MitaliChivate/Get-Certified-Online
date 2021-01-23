import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Training } from '../models/training.model';
import { TrainingserviceService } from '../service/trainingservice.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  training:Training;

  trainingProgramId:number;
  
  constructor(private router: Router, private service: TrainingserviceService,private route:ActivatedRoute) { }

  ngOnInit(){
    this.route.params.subscribe(x=>this.trainingProgramId=x['trainingProgramId']);
    //console.log(this.training.trainingProgramId);
    if(this.trainingProgramId){
      this.service.fetchTrainingByTrainingId(this.trainingProgramId).subscribe(data=>{
        this.training=data;
        console.log(data);
      })
    }
   

  }


  redirectHome(){

  }

}
