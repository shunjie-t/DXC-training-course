import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-electronic-list',
  template: `
    <div *ngFor="let i of list | keyvalue">
      <p>{{i.key}} {{i.value}}</p>
    </div>
  `,
  styles: [
  ]
})
export class ElectronicListComponent implements OnInit {
  public list = {1: "mobile phone", 2: "laptop", 3: "earpiece", 4: "desktop", 5: "usb flash drive", 6: "monitor screen"};

  constructor() { }

  ngOnInit(): void {
  }

}
