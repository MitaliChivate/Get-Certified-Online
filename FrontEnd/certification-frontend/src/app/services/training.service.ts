import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TrainingService {
  serviceUrl= "http://localhost:9300/TrainingProgram"

  constructor(private http : HttpClient) { }

  viewAllTrainings() {
    return this.http.get(this.serviceUrl + '/searchAllTrainingProgram');
  }

  addTraining(formdata){
    return this.http.post(this.serviceUrl + '/addTrainingProgram', formdata);
 
  }
  updateTraining(formData) {
    return this.http.put(this.serviceUrl + '/updateTrainingProgram', formData);
  }

  fetchById(id) {
    return this.http.get(this.serviceUrl + '/searchTrainingProgramById/' + id);
  }

  deleteTrainingRecord(id) {
    console.log(id)
    return this.http.delete(this.serviceUrl+ "/deleteTrainingProgram/"+ id);
 
  }
}
