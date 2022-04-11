import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-test',
  /* templateUrl: './test.component.html', */
  template: `
  <!-- <h2 *ngIf="disp; else elseBlock">Title</h2>
  <ng-template #elseBlock>
    <h2>Body</h2>
  <ng-template> -->

  
  <!-- <div *ngIf="disp; then valueTrue else valueFalse"></div>
  <ng-template #valueTrue><h2>Up</h2></ng-template>
  <ng-template #valueFalse><h2>Down</h2></ng-template> -->

  <!-- <div [ngSwitch]="day">
    <div *ngSwitchCase="'mon'">Chosen Monday</div>
    <div *ngSwitchCase="'tue'">Chosen Tuesday</div>
    <div *ngSwitchCase="'wed'">Chosen Wednesday</div>
    <div *ngSwitchCase="'thu'">Chosen Thursday</div>
    <div *ngSwitchCase="'fri'">Chosen Friday</div>
    <div *ngSwitchCase="'sat'">Chosen Saturday</div>
    <div *ngSwitchCase="'sun'">Chosen Sunday</div>
    <div *ngSwitchDefault>Invalid day chosen</div>
  </div> -->


  <!-- <div *ngFor="let indv of participants; index as idx">
    <h2>{{idx}}. {{indv}}</h2>
  </div> -->
  <!-- <hr>
  <div *ngFor="let indv of participants; odd as o">
    <h2>{{o}}. {{indv}}</h2>
  </div> -->
  <!-- <hr>
  <div *ngFor="let indv of participants; even as e">
    <div *ngIf="e;"><h2>{{e}}. {{indv}}</h2></div>
  </div> -->
  <!-- <hr>
  <div *ngFor="let indv of participants; first as f">
    <h2>{{f}}. {{indv}}</h2>
  </div> -->
  <!-- <hr>
  <div *ngFor="let indv of participants; last as l">
    <h2>{{l}}. {{indv}}</h2>
  </div> -->
  <!-- <hr>
  <div *ngFor="let indv of participants; odd as e">
    <div *ngIf="e; else odd"><h2>{{indv}}</h2></div>
    <ng-template #odd>{{indv}}</ng-template>
  </div> -->
  <!-- <hr>
  <div *ngFor="let a of kvPair|keyvalue">
    <h2>Key = {{a.key}} and Value = {{a.value}}</h2>
  </div> -->

  <h2>{{"Data received from parent: "+msg}}</h2>
  <button (click)="sendData()">Send to parent</button>
  `,
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
  public disp = true;
  public day = "fri";
  public participants = ["colin","audrey","yong","haziq","jj","wen xing","wen han","shufa","shun jie","kai sheng","yu xiang"];
  public kvPair = {"A":1,"B":2,"C":3,"D":4,"E":5,"F":6};

  @Input('dataFromParent') public msg = "";
  @Output() public childEvent = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  sendData() {
    this.childEvent.emit("To Parent");
  }
}
