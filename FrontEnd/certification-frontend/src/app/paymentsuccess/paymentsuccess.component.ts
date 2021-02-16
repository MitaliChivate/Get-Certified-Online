import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-paymentsuccess',
  templateUrl: './paymentsuccess.component.html',
  styleUrls: ['./paymentsuccess.component.css']
})
export class PaymentsuccessComponent implements OnInit {

  cost:number;
  date : Date;
  constructor(private route: ActivatedRoute,private snackBar :MatSnackBar) { }

  ngOnInit(): void {
    this.cost=this.route.snapshot.params['id'];
    this.date=new Date();
    this.snackBar.open('Payment details sent to your registered Email Id','',{duration:4000,verticalPosition:'top',panelClass:'my-custom-snackbargreen'})
               

  }

}
