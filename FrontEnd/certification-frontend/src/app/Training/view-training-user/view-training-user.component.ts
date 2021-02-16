import { Component, OnInit } from '@angular/core';
import { Training } from 'src/app/models/training.model';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { TrainingService } from 'src/app/services/training.service';
import { PaymentService } from 'src/app/services/payment.service';

@Component({
  selector: 'app-view-training-user',
  templateUrl: './view-training-user.component.html',
  styleUrls: ['./view-training-user.component.css']
})
export class ViewTrainingUserComponent implements OnInit {

  training : Training;
  trainings : Training[];
  training1: Training[];

  isLoading: boolean = true
  bucketSize: number=5;
  p: number ;
  num: number;
  constructor(public  router :Router,private snackBar : MatSnackBar,private service : TrainingService, private pService : PaymentService) { }

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

  reload(){
    this.service.viewAllTrainings()
    .subscribe((response: Training[]) => {
      this.trainings = response;
      this.training1=  response;
      this.isLoading= false;
    });
    this.router.navigate(['/navbaruser/viewtraininguser']);
  }
  routerPayment(id : number){
    console.log(id)
    this.pService.checkAlreadyEnrolledCourse(id).subscribe(
      data=>{
        this.num=data;
        console.log(this.num)
        if(this.num==0)
        this.router.navigate(['/navbaruser/coursepayment',id]);
        else
        this.snackBar.open('You have already enrolled for this course! ','',{duration:2000,verticalPosition:'top',panelClass:'my-custom-snackbar'})
                 
      },
      error=>{
        this.snackBar.open('Error Occured! ','',{duration:2000,verticalPosition:'top',panelClass:'my-custom-snackbar'})
      
      }
      )  
  }

  onKey(event: any) {
    this.training1 = this.trainings.filter(trainings => trainings.trainingCourse.toLowerCase().includes(event.target.value))
    if (event.target.value == '' || event.target.value == undefined)
      this.training1 = this.trainings
  }

}
