import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserListTrainingComponent } from './user-list-training.component';

describe('UserListTrainingComponent', () => {
  let component: UserListTrainingComponent;
  let fixture: ComponentFixture<UserListTrainingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserListTrainingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserListTrainingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
