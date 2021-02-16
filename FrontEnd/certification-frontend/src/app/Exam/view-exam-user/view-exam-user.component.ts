import { Component, OnInit } from '@angular/core';
import { Exam } from 'src/app/models/exam.model';
import { ExamService } from 'src/app/services/exam.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { PaymentService } from 'src/app/services/payment.service';

@Component({
  selector: 'app-view-exam-user',
  templateUrl: './view-exam-user.component.html',
  styleUrls: ['./view-exam-user.component.css']
})
export class ViewExamUserComponent implements OnInit {

  exam:Exam;
  exams:Exam[];
  exam1: Exam[];
  isLoading: boolean = true
  bucketSize: number=5;
  p: number ;
  num: number;
  constructor(public service : ExamService,public  router :Router,private snackBar : MatSnackBar,private pService : PaymentService) { }

  ngOnInit(): void {
    this.service.viewAllExams()
    .subscribe((response: Exam[]) => {
      this.exams = response;
      this.exam1=  response;
      this.isLoading= false;
    },error=>{
      this.isLoading= false;
      this.snackBar.open('No exams are available! ','',{duration:2000,verticalPosition:'top'})
          
    }
    );

    setTimeout(() => { this.reload() }, 100);
  }

  routerPayment(id : number){
this.pService.checkAvailableSeats(id).subscribe(

  data=>{

    this.num=data;
    if(this.num==0)
    this.snackBar.open('Sorry! Seats are not available ','',{duration:2000,verticalPosition:'top',panelClass:'my-custom-snackbar'})
     else{
      this.pService.checkAlreadyEnrolledExam(id).subscribe(
        data=>{
          this.num=data;
          if(this.num==0)
          this.router.navigate(['/navbaruser/exampayment',id]);
          else
          this.snackBar.open('You have already enrolled for this exam! ','',{duration:2000,verticalPosition:'top',panelClass:'my-custom-snackbar'})
                   
        },
        error=>{
          this.snackBar.open('Error Occured! ','',{duration:2000,verticalPosition:'top',panelClass:'my-custom-snackbar'})
        
        }
        ) 

     }

  },
  error=>{
    this.snackBar.open('Error Occured! ','',{duration:2000,verticalPosition:'top',panelClass:'my-custom-snackbar'})
  
  }
)

     
  }

  reload(){
    this.service.viewAllExams()
    .subscribe((response: Exam[]) => {
      this.exams = response;
      this.exam1=  response;
      this.isLoading= false;
    });
    this.router.navigate(['/navbaruser/viewexamuser']);
  }


  onKey(event: any) {
    this.exam1 = this.exams.filter(exams => exams.examName.toLowerCase().includes(event.target.value))
    if (event.target.value == '' || event.target.value == undefined)
      this.exam1 = this.exams
  }
}
