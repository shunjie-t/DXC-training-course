import { Component } from '@angular/core';
import { User } from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  cities = ['India','Malaysia','Indonesia'];

  userData = new User('ahkil','ahkil@gmail.com',124567,'India','male',true)
}
