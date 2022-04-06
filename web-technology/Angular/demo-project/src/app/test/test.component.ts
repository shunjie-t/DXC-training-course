import { Component, OnInit } from '@angular/core';

@Component({
  selector: '[app-test]',
  // templateUrl: './test.component.html',
  template: `<input [disabled]="isDisabled" type="text" value="WELCO!">
  <input bind-disabled="isDisabled" type="text" value="ME!">
  <h2 class="txt" [class]="classBlue">Bana</h2>
  <h2 class="txt" [class.red]="colorEnabled">Giri</h2>
  <h1 [ngClass]="textStyle">Welcome to multiple styles</h1>
  <h2 [style.color]="'purple'">Style binding</h2>
  <h2 [style.color]="classGreen ? 'green' : 'red'">Ternary style binding</h2>
  <h2 [style.color]="mark">Angular style binding</h2>
  <h2 [ngStyle]="allStyle">styled by ngStyle</h2>
  <button (click)="clicked($event)">click here</button>
  <br><br>
  <input type="text" [(ngModel)]="name" placeholder="two way binding">{{name}}`,
  // styleUrls: ['./test.component.css']
  styles: [`
    .red {
      color: red;
    }

    .green {
      color: green;
    }

    .purple {
      color: purple;
    }

    .italic {
      font-style: italic;
    }
  `]
})
export class TestComponent implements OnInit {
  public testVar = "demo123";
  public isDisabled = true;

  public classBlue = "blue";
  public colorEnabled = true;

  public classGreen = false;
  public mark = "orange";

  public textStyle = {
    "green": true,
    "red": false, 
    "italic": true,
  }

  public allStyle = {
    color: "yellow",
    fontStyle: "italic"
  }

  public msg = "";
  clicked(event : MouseEvent) {
    this.msg="Btn click";
    alert(this.msg);
    console.log(event);
  }

  public name = "Michael";

  constructor() { }
  ngOnInit(): void {}
}
