import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewTrainingUserComponent } from './view-training-user.component';

describe('ViewTrainingUserComponent', () => {
  let component: ViewTrainingUserComponent;
  let fixture: ComponentFixture<ViewTrainingUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewTrainingUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewTrainingUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
