import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppComponent } from './app.component';
import { AdminDashBoardComponent } from './admin-dash-board/admin-dash-board.component';
import { UserDashBoardComponent } from './user-dash-board/user-dash-board.component';
import { LoginComponent } from './login/login.component';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import {NgxPaginationModule} from 'ngx-pagination';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { ListTrainingComponent } from './list-training/list-training.component';
import { ListExamComponent } from './list-exam/list-exam.component';
import { AddTrainingComponent } from './add-training/add-training.component';
import { AddExamComponent } from './add-exam/add-exam.component';
import { ListUsersComponent } from './list-users/list-users.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { UserListExamsComponent } from './user-list-exams/user-list-exams.component';
import { UserListTrainingComponent } from './user-list-training/user-list-training.component';
import { PaymentTrainingComponent } from './payment-training/payment-training.component';
import { PaymentExamComponent } from './payment-exam/payment-exam.component';



@NgModule({
  declarations: [
    AppComponent,
    AdminDashBoardComponent,
    UserDashBoardComponent,
    LoginComponent,
    ListTrainingComponent,
    ListExamComponent,
    AddTrainingComponent,
    AddExamComponent,
    ListUsersComponent,
    AdminProfileComponent,
    UserListExamsComponent,
    UserListTrainingComponent,
    PaymentTrainingComponent,
    PaymentExamComponent,
 
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NgbModule,
    NgxPaginationModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
