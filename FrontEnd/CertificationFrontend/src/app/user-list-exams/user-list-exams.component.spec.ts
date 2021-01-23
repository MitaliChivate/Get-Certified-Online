import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserListExamsComponent } from './user-list-exams.component';

describe('UserListExamsComponent', () => {
  let component: UserListExamsComponent;
  let fixture: ComponentFixture<UserListExamsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserListExamsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserListExamsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
