import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';
import { AuthenticateService } from 'src/app/services/authenticate.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent implements OnInit {

 
  user : User;
  constructor(private service : UserService, private auth: AuthenticateService,private router : Router) { 
    this.fetchUser();
  }

  ngOnInit(): void {
    

  }
  fetchUser(){
    this.service.fetchById( this.auth.fetchFromSessionStorage()?.userId).subscribe(
      (data: User) => {
        console.log(data);
        this.user = data;
      },
      (error) => console.log(error)
    );
  }
  updateUser(id){
    if(this.user.role=="admin")
    this.router.navigate(['/navbar/updateuser',id]);
    if(this.user.role=="user")
    this.router.navigate(['/navbaruser/updateuser',id]);
   
    
  }

}
