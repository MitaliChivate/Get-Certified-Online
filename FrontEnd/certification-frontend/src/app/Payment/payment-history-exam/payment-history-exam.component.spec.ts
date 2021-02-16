import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentHistoryExamComponent } from './payment-history-exam.component';

describe('PaymentHistoryExamComponent', () => {
  let component: PaymentHistoryExamComponent;
  let fixture: ComponentFixture<PaymentHistoryExamComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaymentHistoryExamComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PaymentHistoryExamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
