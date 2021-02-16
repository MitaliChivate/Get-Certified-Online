import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckUsernameComponent } from './check-username.component';

describe('CheckUsernameComponent', () => {
  let component: CheckUsernameComponent;
  let fixture: ComponentFixture<CheckUsernameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CheckUsernameComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckUsernameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
