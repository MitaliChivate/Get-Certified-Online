import { Component, OnInit } from '@angular/core';
import { Exam } from 'src/app/models/exam.model';
import { Router, ActivatedRoute } from '@angular/router';
import { ExamService } from 'src/app/services/exam.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-update-exam',
  templateUrl: './update-exam.component.html',
  styleUrls: ['./update-exam.component.css']
})
export class UpdateExamComponent implements OnInit {

  id: number;
  exam: Exam;
  validationDate = new Date().toISOString().slice(0,10);
  constructor(private route: ActivatedRoute ,private router : Router, private service : ExamService, private snackBar : MatSnackBar) { }

  ngOnInit(): void {
    this.exam=new Exam();

    this.id=this.route.snapshot.params['id'];

    this.service.fetchById(this.id).subscribe(
      (data: Exam) => {
        console.log(data);
        this.exam = data;
      },
      (error) => console.log(error)
    );
  }
  updateExam() {
    this.service.updateExam(this.exam).subscribe(
      (data) => {
        console.log(data);
        this.exam = new Exam();
        this.gotoList();
        this.snackBar.open('Record Updated!','',{duration:4000,verticalPosition:'top',panelClass:'my-custom-snackbargreen'})
      },
      (error) => console.log(error)
    );
  }
  gotoList() {
    this.router.navigate(['/navbar/viewexam']);
  }


  onSubmit() {
    this.updateExam();
  }

}
