import { Component, OnInit } from '@angular/core';
import { EmployeeServiceService } from '../employee-service.service';

@Component({
  selector: 'app-employee',
  // templateUrl: './employee.component.html',
  template: `
    <h2>Name of Employee collected from the service are</h2>

    <ul *ngFor="let ps of emp">
      <li>{{ps.name}} {{ps.dept}}</li>
    </ul>
  `,
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  public emp = [{ name: '', dept: ''}];
  
  constructor(private _employeeService: EmployeeServiceService) { }

  ngOnInit(): void {
    this.emp = this._employeeService.getEmployeeInfo();
  }

}
