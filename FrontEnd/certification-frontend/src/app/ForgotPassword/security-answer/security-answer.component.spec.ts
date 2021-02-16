import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SecurityAnswerComponent } from './security-answer.component';

describe('SecurityAnswerComponent', () => {
  let component: SecurityAnswerComponent;
  let fixture: ComponentFixture<SecurityAnswerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SecurityAnswerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SecurityAnswerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
