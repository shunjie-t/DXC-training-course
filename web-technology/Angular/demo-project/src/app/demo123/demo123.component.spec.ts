import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Demo123Component } from './demo123.component';

describe('Demo123Component', () => {
  let component: Demo123Component;
  let fixture: ComponentFixture<Demo123Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Demo123Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Demo123Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
