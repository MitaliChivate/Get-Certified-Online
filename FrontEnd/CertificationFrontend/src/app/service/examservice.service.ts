import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Exam } from '../models/exam.model';

@Injectable({
  providedIn: 'root'
})
export class ExamserviceService {

  constructor(private http: HttpClient) { }

  countExam() {
    return this.http.get("http://localhost:9400/exam/count");
  }

  addExam(exam: Exam): Observable<Object> {
    return this.http.post("http://localhost:9400/exam/addExams", exam);
  }

  deleteExam(examId: number) {
    return this.http.delete("http://localhost:9400/exam/deleteExam/" + examId);
  }

  fetchAllExams() {
    return this.http.get<Exam[]>("http://localhost:9400/exam/getAllExams");
  }

  fetchExamByExamId(index: number) {
    return this.http.get<Exam>("http://localhost:9400/exam/findByExamId/" + index);
  }

  checkEnrollExam(examId :number) : Observable<Object>{
    return this.http.get<any>("http://localhost:9500/Payment/checkExamEnrolled/" +examId);
  }

}
