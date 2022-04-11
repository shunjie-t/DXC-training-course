import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {

  constructor() { }

  getEmployeeInfo() {
    return [
      {"id":1,"name":"Ahkil","dept":"training"},
      {"id":2,"name":"Haziq","dept":"jfs"},
      {"id":3,"name":"Yong","dept":"jfs"}
    ];
  }
}
