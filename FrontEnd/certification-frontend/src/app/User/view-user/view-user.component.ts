import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrls: ['./view-user.component.css']
})
export class ViewUserComponent implements OnInit {

  user : User;
  users : User[];
  user1: User[];
  isLoading: boolean = true
  bucketSize: number=5;
  p: number ;
  constructor(private service : UserService, private router : Router,private snackBar : MatSnackBar) { }

  ngOnInit(): void {
    
    this.service.viewAllUsers()
    .subscribe((response: User[]) => {
      this.users = response;
      this.user1=response;
      this.isLoading= false;
      
    });
    setTimeout(() => { this.reload() }, 100);
  }
  updateUser(id : number){
    this.router.navigate(['/navbar/updateuser', id]);

  }

  deleteUser(id){
    this.service.deleteUserRecord(id) .subscribe((response: User[]) => {
      this.users = response;
    });
    this.snackBar.open('User deleted!','',{duration:4000,verticalPosition:'top',panelClass:'my-custom-snackbargreen'})
   this.ngOnInit();
    this.reload();
    

  }
  reload(){
    this.service.viewAllUsers()
    .subscribe((response: User[]) => {
      this.users = response;
      this.user1=  response;
      this.isLoading= false;
    });
    this.router.navigate(['/navbar/viewuser']);
  }
  navigate(): void {
    this.router.navigate(['/navbar/adduser']);
  }


  onKey(event: any) {
    this.user1 = this.users.filter(users => users.userName.toLowerCase().includes(event.target.value))
    if (event.target.value == '' || event.target.value == undefined)
      this.user1 = this.users
  }
}
