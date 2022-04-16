import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-food-list',
  template: `
    <div *ngFor="let i of list | keyvalue">
      <p>{{i.key}} {{i.value}}</p>
    </div>
`,
  styles: [
  ]
})
export class FoodListComponent implements OnInit {
  public list = {1: "tomato", 2: "beef", 3: "cabbage", 4: "chicken", 5: "potato", 6: "corn"};

  constructor() { }

  ngOnInit(): void {
  }

}
