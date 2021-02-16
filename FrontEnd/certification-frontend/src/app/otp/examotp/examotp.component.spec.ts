import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamotpComponent } from './examotp.component';

describe('ExamotpComponent', () => {
  let component: ExamotpComponent;
  let fixture: ComponentFixture<ExamotpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExamotpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamotpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
