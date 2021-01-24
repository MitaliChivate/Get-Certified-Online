import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentExamComponent } from './payment-exam.component';

describe('PaymentExamComponent', () => {
  let component: PaymentExamComponent;
  let fixture: ComponentFixture<PaymentExamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaymentExamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaymentExamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
