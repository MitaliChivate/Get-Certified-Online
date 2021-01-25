import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PaymentTraining } from '../models/paymenttraining.model';

@Injectable({
  providedIn: 'root'
})
export class PaymentserviceService {

  constructor(private http: HttpClient) { }

  makePaymentForTraining(payment: PaymentTraining): Observable<Object> {
    return this.http.post("http://localhost:9500/Payment/makePaymentForTraining", payment);
  }

}
