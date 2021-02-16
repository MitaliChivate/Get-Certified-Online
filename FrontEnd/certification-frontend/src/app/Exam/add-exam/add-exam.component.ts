import { Component, OnInit } from '@angular/core';
import { Exam } from 'src/app/models/exam.model';
import { Router } from '@angular/router';
import { ExamService } from 'src/app/services/exam.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-add-exam',
  templateUrl: './add-exam.component.html',
  styleUrls: ['./add-exam.component.css']
})
export class AddExamComponent implements OnInit {

  exam: Exam;
  exam1: Exam;

  validationDate = new Date().toISOString().slice(0,10);
  difference_in_milliseconds: any;
  dtEnd : any;
  dtStart : any;
  constructor(private router : Router,private service : ExamService, private snackBar : MatSnackBar) {
    this.exam=new Exam();
   }

  ngOnInit(): void {
    this.exam=new Exam();
  }

  addNewExam(formdata){
this.exam1=formdata;

  
    this.dtEnd  = new Date("1/1/2011 " +this.exam1.endTime);
   this.dtStart = new Date("1/1/2011 " + this.exam1.startTime);
      this.difference_in_milliseconds = this.dtEnd - this.dtStart;
    if (this.difference_in_milliseconds < 0)
    {
      console.log(this.difference_in_milliseconds)
      this.snackBar.open('Start time should be lesser than end time!','',{duration:4000,verticalPosition:'top',panelClass:'my-custom-snackbar'})
    }else{

    this.service.addExam(this.exam).subscribe((res) => {
      this.snackBar.open('Exam added!','',{duration:4000,verticalPosition:'top',panelClass:'my-custom-snackbargreen'})
   
      this.router.navigate(['/navbar/viewexam']);

 });
    }

}
}
