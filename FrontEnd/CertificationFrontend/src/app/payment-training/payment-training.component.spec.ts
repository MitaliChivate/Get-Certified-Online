import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentTrainingComponent } from './payment-training.component';

describe('PaymentTrainingComponent', () => {
  let component: PaymentTrainingComponent;
  let fixture: ComponentFixture<PaymentTrainingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaymentTrainingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaymentTrainingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
