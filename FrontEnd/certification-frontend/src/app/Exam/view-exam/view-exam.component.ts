import { Component, OnInit } from '@angular/core';
import { Exam } from 'src/app/models/exam.model';
import { ExamService } from 'src/app/services/exam.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthenticateService } from 'src/app/services/authenticate.service';

@Component({
  selector: 'app-view-exam',
  templateUrl: './view-exam.component.html',
  styleUrls: ['./view-exam.component.css']
})
export class ViewExamComponent implements OnInit {

  exam:Exam;
  exams:Exam[];
  exam1: Exam[];
  
  isLoading: boolean = true
  bucketSize: number=5;
  p: number ;
  constructor(private auth : AuthenticateService,public service : ExamService,public  router :Router,private snackBar : MatSnackBar) { }

  ngOnInit(): void {
    
    this.service.viewAllExams()
    .subscribe((response: Exam[]) => {
      this.exams = response;
      this.exam1=  response;
      this.isLoading= false;
    },error=>{
      this.isLoading= false;
      this.snackBar.open('No exams are available! ','',{duration:2000,verticalPosition:'top'})
          
    });

    setTimeout(() => { this.reload() }, 100);

  
  }

  updateExam(id : number){
    this.router.navigate(['/navbar/updateexam', id]);

  }

  deleteExam(id){
    this.service.deleteExamRecord(id) .subscribe((response: Exam[]) => {
      this.exams = response;
    });
    this.snackBar.open('Exam deleted!','',{duration:4000,verticalPosition:'top',panelClass:'my-custom-snackbargreen'})
    this.ngOnInit();
    this.reload();

  }

  reload(){
    this.service.viewAllExams()
    .subscribe((response: Exam[]) => {
      this.exams = response;
      this.exam1=  response;
      this.isLoading= false;
    });
    this.router.navigate(['/navbar/viewexam']);
  }
  navigate(): void {
    this.router.navigate(['/navbar/addexam']);
  }

  onKey(event: any) {
    this.exam1 = this.exams.filter(exams => exams.examName.toLowerCase().includes(event.target.value))
    if (event.target.value == '' || event.target.value == undefined)
      this.exam1 = this.exams
  }

}
