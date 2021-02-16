import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Exam } from '../models/exam.model';

@Injectable({
  providedIn: 'root'
})
export class ExamService {
 

  serviceUrl= "http://localhost:9400/exam"

  constructor(private http : HttpClient) { }

  viewAllExams() {
    return this.http.get(this.serviceUrl + '/getAllExams');
  }

  addExam(formdata){
    return this.http.post(this.serviceUrl +'/addExams', formdata);
 
  }
  updateExam(formData) {
    return this.http.put(this.serviceUrl + '/updateExamInfo', formData);
  }

  fetchById(id) {
    return this.http.get(this.serviceUrl + '/findByExamId/' + id);
  }

  deleteExamRecord(id) {
    console.log(id)
    return this.http.delete(this.serviceUrl+ "/deleteExam/"+ id);
 
  }

  getReminder(id : number, exam : Exam){
    return this.http.post(this.serviceUrl +"/sendReminder/"+id, exam);
 
  }
}
