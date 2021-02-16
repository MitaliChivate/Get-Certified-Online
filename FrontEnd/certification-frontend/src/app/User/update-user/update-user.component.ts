import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthenticateService } from 'src/app/services/authenticate.service';


@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {


  id: number;
  user:User;
  constructor(private route: ActivatedRoute ,private router : Router,private snackBar : MatSnackBar,private service : UserService,private auth :AuthenticateService) { }

  ngOnInit(): void {
    this.user=new User();

    this.id=this.route.snapshot.params['id'];

    this.service.fetchById(this.id).subscribe(
      (data: User) => {
        console.log(data);
        this.user = data;
      },
      (error) => console.log(error)
    );
  }

  updateUser() {
    this.service.updateUser(this.user).subscribe(
      (data) => {
        console.log(data);
        this.user = new User();
      
        this.gotoProfile();
        this.snackBar.open('Profile Updated!','',{duration:4000,verticalPosition:'top',panelClass:'my-custom-snackbargreen'})
      },
      (error) => console.log(error)
    );
  }

  gotoProfile() {
    if(this.auth.typeOfUser()=="admin"){
      console.log(this.user.role);
    this.router.navigate(['/navbar/myprofile']);
  
  }
    if(this.auth.typeOfUser()=="user")
    this.router.navigate(['/navbaruser/myprofile']);
   
  }


  onSubmit() {
    this.updateUser();
  }

}
