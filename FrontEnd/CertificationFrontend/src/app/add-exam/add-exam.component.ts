import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Exam } from '../models/exam.model';
import { ExamserviceService } from '../service/examservice.service';

@Component({
  selector: 'app-add-exam',
  templateUrl: './add-exam.component.html',
  styleUrls: ['./add-exam.component.css']
})
export class AddExamComponent implements OnInit {

  exam: Exam;
  isadded: boolean = false
  constructor(private router: Router, private service: ExamserviceService) {
    this.exam = new Exam()
  }

  ngOnInit() {
  }

  saveExam() {
    console.log(this.exam.examName);

    this.service.addExam(this.exam).subscribe(response => {
      this.isadded = true
    });


  }

}
