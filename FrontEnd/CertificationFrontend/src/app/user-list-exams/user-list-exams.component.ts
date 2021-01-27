import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Exam } from '../models/exam.model';
import { ExamserviceService } from '../service/examservice.service';

@Component({
  selector: 'app-user-list-exams',
  templateUrl: './user-list-exams.component.html',
  styleUrls: ['./user-list-exams.component.css']
})
export class UserListExamsComponent implements OnInit {


  exams: Exam[] = [];
  exam: Exam;
  exam1: Exam[] = [];

  //Flags required for interactive UI
  isAdded: boolean = null
  isUpdated: boolean = false
  isLoading: boolean = true
  isErrorUpdating: boolean = false

  sortedById: boolean = null
  sortedByName: boolean = null
  sortedByDes: boolean = null
  isDeleteError: boolean = false
  examName: String;
  descriptions: string;


  constructor(private route: Router, private service: ExamserviceService) { }

  ngOnInit(): void {
    this.exams = []
    this.exam1 = []



    setTimeout(() => { this.reloadData() }, 100);
  }

  reloadData() {
    this.service.fetchAllExams().subscribe(
      (data => {
        this.exam1 = data;
        this.exams = data
        this.isLoading = false
      }

      )
    )
  }


  routerPayment(exam) {
    this.route.navigate(['/user/dashboard/payment-exam', exam.examId])
  }

  onKey(event: any) {
    this.exam1 = this.exams.filter(exams => exams.examName.includes(event.target.value))
    if (event.target.value == '' || event.target.value == undefined)
      this.exam1 = this.exams
  }

  getDetailsById(examId: number) {
    console.log(examId)

    this.service.fetchExamByExamId(examId).subscribe((res) => {
      this.exam = res;
      this.examName = this.exam.examName
      this.descriptions = this.exam.description
    })

  }

  logout() {
    sessionStorage.clear();
    this.route.navigate(['login']);
  }

}
