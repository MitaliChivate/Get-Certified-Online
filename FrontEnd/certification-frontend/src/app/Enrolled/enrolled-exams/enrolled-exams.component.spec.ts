import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnrolledExamsComponent } from './enrolled-exams.component';

describe('EnrolledExamsComponent', () => {
  let component: EnrolledExamsComponent;
  let fixture: ComponentFixture<EnrolledExamsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnrolledExamsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EnrolledExamsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
