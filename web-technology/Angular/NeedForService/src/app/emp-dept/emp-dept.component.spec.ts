import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpDeptComponent } from './emp-dept.component';

describe('EmpDeptComponent', () => {
  let component: EmpDeptComponent;
  let fixture: ComponentFixture<EmpDeptComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmpDeptComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpDeptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
