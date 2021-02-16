
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CommonModule } from '@angular/common';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatSelectModule } from '@angular/material/select';
import { MatIconModule } from '@angular/material/icon';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {NgxPaginationModule} from 'ngx-pagination';
import {MatMenuModule} from '@angular/material/menu';

import { HomeComponent } from './home/home.component';
import { NavbaruserComponent } from './navbaruser/navbaruser.component';
import { ViewUserComponent } from './User/view-user/view-user.component';
import { RegisterUserComponent } from './User/register-user/register-user.component';
import { AddTrainingComponent } from './Training/add-training/add-training.component';
import { ViewTrainingComponent } from './Training/view-training/view-training.component';
import { UpdateTrainingComponent } from './Training/update-training/update-training.component';
import { AddExamComponent } from './Exam/add-exam/add-exam.component';
import { ViewExamComponent } from './Exam/view-exam/view-exam.component';
import { UpdateExamComponent } from './Exam/update-exam/update-exam.component';
import { MyProfileComponent } from './User/my-profile/my-profile.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { AddUserComponent } from './User/add-user/add-user.component';
import { UpdateUserComponent } from './User/update-user/update-user.component';
import { ViewExamUserComponent } from './Exam/view-exam-user/view-exam-user.component';
import { FooterComponent } from './footer/footer.component';
import { ViewTrainingUserComponent } from './Training/view-training-user/view-training-user.component';
import { ExampaymentComponent } from './Payment/exampayment/exampayment.component';
import { CoursepaymentComponent } from './Payment/coursepayment/coursepayment.component';
import { SpinnerComponent } from './spinner/spinner.component';
import { PaymentsuccessComponent } from './paymentsuccess/paymentsuccess.component';
import { PaymentHistoryExamComponent } from './Payment/payment-history-exam/payment-history-exam.component';
import { PaymentHistoryTrainingComponent } from './Payment/payment-history-training/payment-history-training.component';
import { EnrolledCoursesComponent } from './Enrolled/enrolled-courses/enrolled-courses.component';
import { EnrolledExamsComponent } from './Enrolled/enrolled-exams/enrolled-exams.component';
import { ExamPaymentReceivedComponent } from './PaymentReceived/exam-payment-received/exam-payment-received.component';
import { CoursePaymentReceivedComponent } from './PaymentReceived/course-payment-received/course-payment-received.component';

import { BouncerComponent } from './bouncer/bouncer.component';
import { ExamotpComponent } from './Otp/examotp/examotp.component';
import { CourseotpComponent } from './Otp/courseotp/courseotp.component';
import { CheckUsernameComponent } from './ForgotPassword/check-username/check-username.component';
import { SecurityAnswerComponent } from './ForgotPassword/security-answer/security-answer.component';
import { ChangePasswordComponent } from './ForgotPassword/change-password/change-password.component';

export interface ISession {
  session : Object;
}


 


@NgModule({
  declarations: [AppComponent,  LoginComponent, NavbarComponent,  HomeComponent, NavbaruserComponent,  ViewUserComponent, RegisterUserComponent, AddTrainingComponent, ViewTrainingComponent, UpdateTrainingComponent, AddExamComponent, ViewExamComponent, UpdateExamComponent, MyProfileComponent, AddUserComponent,UpdateUserComponent, ViewExamUserComponent, FooterComponent, ViewTrainingUserComponent, ExampaymentComponent, CoursepaymentComponent, SpinnerComponent, PaymentsuccessComponent, PaymentHistoryExamComponent, PaymentHistoryTrainingComponent, EnrolledCoursesComponent, EnrolledExamsComponent, ExamPaymentReceivedComponent, CoursePaymentReceivedComponent, BouncerComponent, ExamotpComponent, CourseotpComponent, CheckUsernameComponent, SecurityAnswerComponent, ChangePasswordComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    CommonModule,
    MatDialogModule,
    MatButtonModule,
    MatTableModule,
    MatSortModule, // Required for Sorting table
    MatPaginatorModule,
    MatCardModule,
    MatFormFieldModule,
    MatProgressSpinnerModule,
    MatInputModule,
    MatSelectModule,
    MatIconModule,
    MatToolbarModule,
    MatSidenavModule,
    MatSnackBarModule,
    MatListModule,
    NgxPaginationModule,
    MatMenuModule
    
    
   
  ],
  exports: [
    MatDialogModule,
    MatButtonModule,
    MatTableModule,
    MatSortModule, // Required for Sorting table
    MatPaginatorModule,
    MatCardModule,
    MatFormFieldModule,
    MatProgressSpinnerModule,
    MatInputModule,
    MatSelectModule,
    MatIconModule,
    MatSidenavModule,
    MatSnackBarModule,
    MatListModule,
    MatMenuModule
    
  ],
  providers: [
   ],
  bootstrap: [AppComponent],
})
export class AppModule {}
