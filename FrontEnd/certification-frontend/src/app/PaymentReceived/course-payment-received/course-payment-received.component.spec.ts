import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursePaymentReceivedComponent } from './course-payment-received.component';

describe('CoursePaymentReceivedComponent', () => {
  let component: CoursePaymentReceivedComponent;
  let fixture: ComponentFixture<CoursePaymentReceivedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoursePaymentReceivedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoursePaymentReceivedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
