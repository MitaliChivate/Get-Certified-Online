import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewExamUserComponent } from './view-exam-user.component';

describe('ViewExamUserComponent', () => {
  let component: ViewExamUserComponent;
  let fixture: ComponentFixture<ViewExamUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewExamUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewExamUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
