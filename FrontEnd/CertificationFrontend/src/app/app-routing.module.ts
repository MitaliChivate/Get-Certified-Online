import { NgModule } from '@angular/core';
import { AuthGuard } from './auth.guard';
import { Routes, RouterModule } from '@angular/router';
import { AdminDashBoardComponent } from './admin-dash-board/admin-dash-board.component';
import { LoginComponent } from './login/login.component';
import { UserDashBoardComponent } from './user-dash-board/user-dash-board.component';
import { AddTrainingComponent } from './add-training/add-training.component';
import { ListTrainingComponent } from './list-training/list-training.component';
import { AddExamComponent } from './add-exam/add-exam.component';
import { ListExamComponent } from './list-exam/list-exam.component';
import { ListUsersComponent } from './list-users/list-users.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { UserListTrainingComponent } from './user-list-training/user-list-training.component';
import { UserListExamsComponent } from './user-list-exams/user-list-exams.component';


const routes: Routes = [
  { path: '', component: LoginComponent},
  { path: 'login', component: LoginComponent },

  {
    path: 'admin/dashboard', component:  AdminDashBoardComponent, children: [

      { path: 'training/add', component: AddTrainingComponent },
      { path: 'training/view', component: ListTrainingComponent },
      { path: 'exam/add', component: AddExamComponent },
      { path: 'exam/view', component: ListExamComponent },
      { path: 'user/view', component: ListUsersComponent },
      { path: 'user/profile', component:  AdminProfileComponent},
      
    ], 
  },

  {
    path: 'user/dashboard', component: UserDashBoardComponent, children: [
      { path: 'training/add', component: UserListTrainingComponent },
      { path: 'exam/add', component: UserListExamsComponent },
      { path: 'user/profile', component:  AdminProfileComponent},
      { path: 'payment', component:  AdminProfileComponent},
    ], //canActivate: [AuthGuard]
  },
  // { path: '**', component: ErrorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


