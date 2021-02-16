import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseotpComponent } from './courseotp.component';

describe('CourseotpComponent', () => {
  let component: CourseotpComponent;
  let fixture: ComponentFixture<CourseotpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CourseotpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseotpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
