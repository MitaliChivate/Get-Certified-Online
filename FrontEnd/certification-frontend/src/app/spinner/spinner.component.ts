import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-spinner',
  templateUrl: './spinner.component.html',
  styleUrls: ['./spinner.component.css']
})
export class SpinnerComponent implements OnInit {

  cost:number;
  showSpinner:boolean;
  constructor(private router : Router,private route: ActivatedRoute) {
   
   }

  ngOnInit(): void {
    this.showSpinner=false;
    this.showSpinner=true;
    this.cost=this.route.snapshot.params['id'];
    setTimeout(() => {
      this.router.navigate(['/navbaruser/paymentsuccess',this.cost]);
      
    }, 9000);
  }


  loadData(){
    
  }
}
