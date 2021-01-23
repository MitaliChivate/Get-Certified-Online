import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../models/user.model';
import { UserserviceService } from '../service/userservice.service';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent implements OnInit {

  custId: string;
  user: User;

  firstName: string;
  lastName: string;
  userName: string;
  email: string;
  dateOfBirth: Date;
  gender: string;
  mobile: number;
  password: string;
  isErrorUpdating: boolean = false;
  isUpdated: boolean;

  inputType: string = "password"
  constructor(private route: ActivatedRoute, private router: Router, private service: UserserviceService) {
    this.user = new User();
  }

  ngOnInit() {

    this.route.params.subscribe(x => this.custId = x['userId']);


    this.service.getUserByUserId(sessionStorage.getItem('custId')).subscribe(data => {
      this.user = data;
      console.log(this.user);

    });

  }

  onUpdate(form: NgForm) {

    if (form.valid) {
      let user = new User()
      user.firstName = form.value.firstName
      user.lastName = form.value.lastName
      user.userName = form.value.userNAme
      user.dateOfBirth = form.value.dateOfBirth
      user.email = form.value.email
      user.gender = form.value.gender
      user.mobileNo = form.value.mobile
      user.password = form.value.password
      user.userId = sessionStorage.getItem('custId')
      user.role = window.atob(sessionStorage.getItem('userType'))
      this.service.updateUser(user).subscribe(res => {
        console.log(res)
        this.isUpdated = true

      })
    }
  }

  //For view password
  toggle() {
    if (this.inputType == "password")
      this.inputType = "text"
    else
      this.inputType = "password"
  }

  reload() {
    this.ngOnInit();
  }

}
