
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { NavbaruserComponent } from './navbaruser/navbaruser.component';
import { AuthGuardAdminService } from './services/auth-guard-admin.service';
import { AuthGuardUserService } from './services/auth-guard-user.service';
import { ViewTrainingComponent } from './Training/view-training/view-training.component';
import { MyProfileComponent } from './User/my-profile/my-profile.component';
import { ViewExamComponent } from './Exam/view-exam/view-exam.component';
import { RegisterUserComponent } from './User/register-user/register-user.component';
import { AddExamComponent } from './Exam/add-exam/add-exam.component';
import { UpdateExamComponent } from './Exam/update-exam/update-exam.component';
import { ViewUserComponent } from './User/view-user/view-user.component';
import { AddUserComponent } from './User/add-user/add-user.component';
import { UpdateUserComponent } from './User/update-user/update-user.component';
import { ViewExamUserComponent } from './Exam/view-exam-user/view-exam-user.component';
import { AddTrainingComponent } from './Training/add-training/add-training.component';
import { UpdateTrainingComponent } from './Training/update-training/update-training.component';
import { ViewTrainingUserComponent } from './Training/view-training-user/view-training-user.component';
import { ExampaymentComponent } from './Payment/exampayment/exampayment.component';
import { CoursepaymentComponent } from './Payment/coursepayment/coursepayment.component';
import { SpinnerComponent } from './spinner/spinner.component';
import { PaymentsuccessComponent } from './paymentsuccess/paymentsuccess.component';
import { PaymentHistoryExamComponent } from './Payment/payment-history-exam/payment-history-exam.component';
import { PaymentHistoryTrainingComponent } from './Payment/payment-history-training/payment-history-training.component';
import { EnrolledExamsComponent } from './Enrolled/enrolled-exams/enrolled-exams.component';
import { EnrolledCoursesComponent } from './Enrolled/enrolled-courses/enrolled-courses.component';
import { CoursePaymentReceivedComponent } from './PaymentReceived/course-payment-received/course-payment-received.component';
import { ExamPaymentReceivedComponent } from './PaymentReceived/exam-payment-received/exam-payment-received.component';

import { BouncerComponent } from './bouncer/bouncer.component';
import { ExamotpComponent } from './Otp/examotp/examotp.component';
import { CourseotpComponent } from './Otp/courseotp/courseotp.component';
import { CheckUsernameComponent } from './ForgotPassword/check-username/check-username.component';
import { SecurityAnswerComponent } from './ForgotPassword/security-answer/security-answer.component';
import { ChangePasswordComponent } from './ForgotPassword/change-password/change-password.component';



const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'registeruser', component: RegisterUserComponent},
  { path: 'login', component: LoginComponent,},
  { path: 'securityanswer/:id', component: SecurityAnswerComponent,},
  { path: 'resetpassword/:id', component: ChangePasswordComponent, }, 
  { path: 'forgotpassword', component: CheckUsernameComponent,},
  { path: 'navbaruser', component: NavbaruserComponent,canActivate :[AuthGuardUserService],
  children: [
    {
      path: '',
      component: HomeComponent,
    }, 
    {
      path: 'viewtraininguser',
      component: ViewTrainingUserComponent,
    },
    {
      path: 'home',
      component: HomeComponent,
    }, 
    {
      path: 'viewexamuser',
      component: ViewExamUserComponent,
    },
    {
      path: 'myprofile',
      component: MyProfileComponent,
    },
    {
      path: 'exampayment/:id',
      component: ExampaymentComponent,
    },
    {
      path: 'coursepayment/:id',
      component: CoursepaymentComponent,
    },
    {
      path: 'updateuser/:id',
      component: UpdateUserComponent,
    },
    {
      path: 'spinner/:id',
      component: SpinnerComponent,
    },
    {
      path: 'paymentsuccess/:id',
      component: PaymentsuccessComponent,
    },
    {
      path: 'paymenthistoryexam',
      component: PaymentHistoryExamComponent,
    },
    {
      path: 'paymenthistorytraining',
      component: PaymentHistoryTrainingComponent,
    },
    {
      path: 'enrolledexams',
      component: EnrolledExamsComponent,
    },
    {
      path: 'enrolledcourses',
      component: EnrolledCoursesComponent,
    },
    {
      path: 'examotp',
      component: ExamotpComponent,
    },
    {
      path: 'courseotp',
      component: CourseotpComponent,
    },
    {
      path: 'bouncer/:id',
      component: BouncerComponent,
    },
   
   
  ]},
  
  
  { path: 'navbar', component: NavbarComponent,canActivate :[AuthGuardAdminService],
  children: [
    {
      path: '',
      component: HomeComponent,
    }, 
    {
      path: 'viewtraining',
      component: ViewTrainingComponent,
    },
    {
      path: 'addtraining',
      component: AddTrainingComponent,
    },
    {
      path: 'updatetraining/:id',
      component: UpdateTrainingComponent,
    },
    {
      path: 'home',
      component: HomeComponent,
    }, 
    {
      path: 'viewexam',
      component: ViewExamComponent,
    },
    {
      path: 'myprofile',
      component: MyProfileComponent,
    },
    {
      path: 'addexam',
      component: AddExamComponent,
    },
    {
      path: 'editexam',
      component: UpdateExamComponent,
    },
    {
      path: 'updateexam/:id',
      component: UpdateExamComponent,
    },
    {
      path: 'viewuser',
      component: ViewUserComponent,
    },
    {
      path: 'adduser',
      component: AddUserComponent,
    },
    {
      path: 'updateuser/:id',
      component: UpdateUserComponent,
    },
    {
      path: 'coursepaymentreceived',
      component: CoursePaymentReceivedComponent,
    },
    {
      path: 'exampaymentreceived',
      component: ExamPaymentReceivedComponent,
    },
   
   
  ]

    
},
  
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
