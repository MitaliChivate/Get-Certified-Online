import { Component, OnInit } from '@angular/core';
import { Training } from 'src/app/models/training.model';
import { TrainingService } from 'src/app/services/training.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-training',
  templateUrl: './add-training.component.html',
  styleUrls: ['./add-training.component.css']
})
export class AddTrainingComponent implements OnInit {

  training : Training;
  validationDate = new Date().toISOString().slice(0,10);

  constructor(private service : TrainingService,private router : Router,private snackBar : MatSnackBar) {
    this.training=new Training();
   }

  ngOnInit(): void {
    this.training=new Training();
  }

  addNewTraining(formdata){

    this.service.addTraining(this.training).subscribe((res) => {
      this.snackBar.open('Course added!','',{duration:4000,verticalPosition:'top',panelClass:'my-custom-snackbargreen'})
   
      this.router.navigate(['/navbar/viewtraining']);

  });
}
}
