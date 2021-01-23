import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Training } from '../models/training.model';
import { TrainingserviceService } from '../service/trainingservice.service';

@Component({
  selector: 'app-list-training',
  templateUrl: './list-training.component.html',
  styleUrls: ['./list-training.component.css']
})
export class ListTrainingComponent implements OnInit {

  trainings: Training[] = [];
  training: Training;
  training1: Training[] = [];

  //Flags required for interactive UI
  isAdded: boolean = null
  isUpdated: boolean = false
  isLoading: boolean = true
  isErrorUpdating: boolean = false

  sortedById: boolean = null
  sortedByName: boolean = null
  sortedByDes: boolean = null
  isDeleteError: boolean = false
  courseName: String;
  descriptions: string;


  constructor(private route: Router, private service: TrainingserviceService) { }

  ngOnInit(): void {
    this.trainings = []
    this.training1 = []



    setTimeout(() => { this.reloadData() }, 100);
  }

  reloadData() {
    this.service.fetchAllTraining().subscribe(
      (data => {
        this.training1 = data;
        this.trainings = data
        this.isLoading = false
      }

      )
    )
  }

  remove(trainingId: number) {
    var ans = confirm("Are you sure you want to delete?");
    if (ans) {
      this.service.deleteTraining(trainingId).subscribe((res) => {
        this.trainings = []
        this.ngOnInit()
      })
    }
  }



  onKey(event: any) {
    this.training1 = this.trainings.filter(trainings => trainings.trainingCourse.includes(event.target.value))
    if (event.target.value == '' || event.target.value == undefined)
      this.training1 = this.trainings
  }

  getDetailsById(trainingProgramId: number) {

    this.service.fetchTrainingByTrainingId(trainingProgramId).subscribe((res) => {
      this.training = res;
      this.courseName = this.training.trainingCourse
      this.descriptions = this.training.description
    })

  }

  logout() {
    sessionStorage.clear();
    this.route.navigate(['login']);
  }

}
