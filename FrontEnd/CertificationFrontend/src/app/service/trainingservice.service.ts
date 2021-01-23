import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Training } from '../models/training.model';

@Injectable({
  providedIn: 'root'
})
export class TrainingserviceService {

  constructor(private http: HttpClient) { }

  countTraining() {
    return this.http.get("http://localhost:9300/TrainingProgram/count");
  }

  addTraining(training: Training): Observable<Object> {
    return this.http.post("http://localhost:9300/TrainingProgram/addTrainingProgram", training);
  }

  deleteTraining(trainingId: number) {
    return this.http.delete("http://localhost:9300/TrainingProgram/deleteTrainingProgram/" + trainingId);
  }

  fetchAllTraining() {
    return this.http.get<Training[]>("http://localhost:9300/TrainingProgram/searchAllTrainingProgram");
  }

  fetchTrainingByTrainingId(index: number) {
    return this.http.get<Training>("http://localhost:9300/TrainingProgram/searchTrainingProgramById/" + index);
  }
}
