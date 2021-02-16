import { Component, OnInit } from '@angular/core';
import { Training } from 'src/app/models/training.model';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { TrainingService } from 'src/app/services/training.service';

@Component({
  selector: 'app-view-training',
  templateUrl: './view-training.component.html',
  styleUrls: ['./view-training.component.css']
})
export class ViewTrainingComponent implements OnInit {

  training : Training;
  trainings : Training[];
  training1: Training[];

  isLoading: boolean = true
  bucketSize: number=5;
  p: number ;
  constructor(public  router :Router,private snackBar : MatSnackBar,private service : TrainingService) { 
    
  
  }

  ngOnInit(): void {
   
   
    this.service.viewAllTrainings()
    .subscribe((response: Training[]) => {
      this.trainings = response;
      this.training1= response;
      this.isLoading= false;
    },error=>{
      this.isLoading= false;
      this.snackBar.open('No Courses are available! ','',{duration:2000,verticalPosition:'top'})
          
    });
    setTimeout(() => { this.reload() }, 100);
  }

  updateTraining(id : number){
    this.router.navigate(['/navbar/updatetraining', id]);

  }

  deleteTraining(id){
    this.service.deleteTrainingRecord(id) .subscribe((response: Training[]) => {
      this.trainings = response;
    });
   
    this.snackBar.open('Course deleted!','',{duration:4000,verticalPosition:'top',panelClass:'my-custom-snackbargreen'})

    this.ngOnInit();
               
    this.reload();
  }

  reload(){
    this.service.viewAllTrainings()
    .subscribe((response: Training[]) => {
      this.trainings = response;
      this.training1=  response;
      this.isLoading= false;
    });
    this.router.navigate(['/navbar/viewtraining']);
  }
  navigate(): void {
    this.router.navigate(['/navbar/addtraining']);
  }

  onKey(event: any) {
    this.training1 = this.trainings.filter(trainings => trainings.trainingCourse.toLowerCase().includes(event.target.value))
    if (event.target.value == '' || event.target.value == undefined)
      this.training1 = this.trainings
  }

}
