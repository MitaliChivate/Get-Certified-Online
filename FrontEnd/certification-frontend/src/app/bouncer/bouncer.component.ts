import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-bouncer',
  templateUrl: './bouncer.component.html',
  styleUrls: ['./bouncer.component.css']
})
export class BouncerComponent implements OnInit {

  id :number;
  constructor(private router : Router,private route :ActivatedRoute) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];


if(this.id>=300000){
    setTimeout(() => {
      this.router.navigate(['/navbaruser/examotp']);
     
    }, 7000);
  }
else{
  setTimeout(() => {
  this.router.navigate(['/navbaruser/courseotp']);
 
}, 7000);


}

  }

}

