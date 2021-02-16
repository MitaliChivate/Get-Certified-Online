import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentHistoryTrainingComponent } from './payment-history-training.component';

describe('PaymentHistoryTrainingComponent', () => {
  let component: PaymentHistoryTrainingComponent;
  let fixture: ComponentFixture<PaymentHistoryTrainingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaymentHistoryTrainingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PaymentHistoryTrainingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
