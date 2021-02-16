import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamPaymentReceivedComponent } from './exam-payment-received.component';

describe('ExamPaymentReceivedComponent', () => {
  let component: ExamPaymentReceivedComponent;
  let fixture: ComponentFixture<ExamPaymentReceivedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExamPaymentReceivedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamPaymentReceivedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
