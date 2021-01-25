import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Training } from '../models/training.model';
import { TrainingserviceService } from '../service/trainingservice.service';

@Component({
  selector: 'app-user-list-training',
  templateUrl: './user-list-training.component.html',
  styleUrls: ['./user-list-training.component.css']
})
export class UserListTrainingComponent implements OnInit {

  trainings: Training[] = [];
  training: Training;
  training1: Training[] = [];

  trainingProgramId:number;

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


  constructor(private route: Router, private service: TrainingserviceService,private router:ActivatedRoute) { }

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

  routerPayment(training){
    this.route.navigate(['/user/dashboard/payment-training',training.trainingProgramId])
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
