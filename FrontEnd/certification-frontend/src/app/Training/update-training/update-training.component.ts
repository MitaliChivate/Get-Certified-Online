import { Component, OnInit } from '@angular/core';
import { TrainingService } from 'src/app/services/training.service';
import { Training } from 'src/app/models/training.model';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-training',
  templateUrl: './update-training.component.html',
  styleUrls: ['./update-training.component.css']
})
export class UpdateTrainingComponent implements OnInit {

id: number;
  training :Training;
  constructor(private route: ActivatedRoute ,private router : Router,private snackBar : MatSnackBar,private service : TrainingService) { }

  ngOnInit(): void {
    this.training=new Training();

    this.id=this.route.snapshot.params['id'];

    this.service.fetchById(this.id).subscribe(
      (data: Training) => {
        console.log(data);
        this.training = data;
      },
      (error) => console.log(error)
    );
  }

  updateTraining() {
    this.service.updateTraining(this.training).subscribe(
      (data) => {
        console.log(data);
        this.training = new Training();
        this.gotoList();
        this.snackBar.open('Record Updated!','',{duration:4000,verticalPosition:'top',panelClass:'my-custom-snackbargreen'})
      },
      (error) => console.log(error)
    );
  }
  gotoList() {
    this.router.navigate(['/navbar/viewtraining']);
  }


  onSubmit() {
    this.updateTraining();
  }

}
