import { Component, OnInit } from '@angular/core';
import { EmployeeServiceService } from '../employee-service.service';

@Component({
  selector: 'app-emp-dept',
  // templateUrl: './emp-dept.component.html',
  template: `
    <h2></h2>

    <ul *ngFor="let ps of emp">
      <li>{{ps.name}}  {{ps.dept}}</li>
    </ul>
  `,
  styleUrls: ['./emp-dept.component.css']
})
export class EmpDeptComponent implements OnInit {
  public emp = [{ name: '', dept: ''}];

  constructor(private _employeeService: EmployeeServiceService) { }

  ngOnInit(): void {
    this.emp = this._employeeService.getEmployeeInfo();
  }

}
