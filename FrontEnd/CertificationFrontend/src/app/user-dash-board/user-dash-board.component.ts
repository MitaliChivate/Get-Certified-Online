import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';
import { ExamserviceService } from '../service/examservice.service';
import { PaymentserviceService } from '../service/paymentservice.service';
import { TrainingserviceService } from '../service/trainingservice.service';
import { UserserviceService } from '../service/userservice.service';

@Component({
  selector: 'app-user-dash-board',
  templateUrl: './user-dash-board.component.html',
  styleUrls: ['./user-dash-board.component.css']
})
export class UserDashBoardComponent implements OnInit {

  sidebarClass: string = ""
  menuToggleClass: string = "container1"
  trainingCount: object = null
  examCount: object = null
  userCount: object = null
  paymentCount: object = null

  isLoadingExam: boolean = true
  isLoadingTraining: boolean = true
  isLoadingUser: boolean = true
  isLoadingPayment: boolean;

  constructor(private router: Router, private examService: ExamserviceService, private trainingService: TrainingserviceService,
    private userService: UserserviceService, private authService: AuthService, private payService : PaymentserviceService) { }

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

    this.payService.countPayments().subscribe(
      res =>{
        this.paymentCount = res
        this.isLoadingPayment = false
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

  userRefresh() {
    this.ngOnInit();
    this.router.navigate(["/user/dashboard"]);
  }

}
