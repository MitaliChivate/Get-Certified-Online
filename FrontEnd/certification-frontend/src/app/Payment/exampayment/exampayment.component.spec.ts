import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExampaymentComponent } from './exampayment.component';

describe('ExampaymentComponent', () => {
  let component: ExampaymentComponent;
  let fixture: ComponentFixture<ExampaymentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExampaymentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExampaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
