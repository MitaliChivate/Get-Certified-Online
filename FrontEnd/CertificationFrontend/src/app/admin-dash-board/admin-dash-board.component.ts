import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';
import { ExamserviceService } from '../service/examservice.service';
import { TrainingserviceService } from '../service/trainingservice.service';
import { UserserviceService } from '../service/userservice.service';

@Component({
  selector: 'app-admin-dash-board',
  templateUrl: './admin-dash-board.component.html',
  styleUrls: ['./admin-dash-board.component.css']
})
export class AdminDashBoardComponent implements OnInit {

  sidebarClass: string = ""
  menuToggleClass: string = "container1"
  trainingCount: object = null
  examCount: object = null
  userCount: object = null

  isLoadingExam: boolean = true
  isLoadingTraining: boolean = true
  isLoadingUser: boolean = true


  constructor(private router: Router, private examService: ExamserviceService, private trainingService: TrainingserviceService,
    private userService: UserserviceService, private authService: AuthService) { }

  ngOnInit(): void {


    this.examService.countExam().subscribe(
      res => {
        this.examCount = res
        this.isLoadingExam = false
      }
    )

    this.trainingService.countTraining().subscribe(
      res => {
        this.trainingCount = res
        this.isLoadingTraining = false
      }
    )

    this.userService.countUser().subscribe(
      res=>{
        this.userCount=res
        this.isLoadingUser=false
      }
    )




  }

  logOut() {
    sessionStorage.clear();
    this.authService.setLoggedIn(false);
    this.router.navigate([''])
  }

  //For toggle
  toggleClass() {
    if (this.sidebarClass == "") {
      this.sidebarClass = "toggled"
      this.menuToggleClass = "container1  clickable"
    }
    else {
      this.sidebarClass = ""
      this.menuToggleClass = "container1 clickable"
    }
  }

  adminRefresh() {
    this.ngOnInit();
    this.router.navigate(["/admin/dashboard"]);
  }

}
