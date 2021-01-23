import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Training } from '../models/training.model';
import { TrainingserviceService } from '../service/trainingservice.service';

@Component({
  selector: 'app-add-training',
  templateUrl: './add-training.component.html',
  styleUrls: ['./add-training.component.css']
})
export class AddTrainingComponent implements OnInit {

  training: Training;
  isadded: boolean = false

  constructor(private router: Router, private service: TrainingserviceService) {
    this.training=new Training();
   }

  ngOnInit() {
  }

  
  saveTraining() {
    console.log(this.training.trainingCourse);

    this.service.addTraining(this.training).subscribe(response => {
      this.isadded = true
    });


  }

}
