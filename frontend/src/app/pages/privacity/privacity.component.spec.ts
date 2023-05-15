import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrivacityComponent } from './privacity.component';

describe('PrivacityComponent', () => {
  let component: PrivacityComponent;
  let fixture: ComponentFixture<PrivacityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrivacityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrivacityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
