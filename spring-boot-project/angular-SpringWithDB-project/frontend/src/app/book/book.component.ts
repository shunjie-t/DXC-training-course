import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from "../book.service";

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  books : Book[] | undefined;
  constructor(private bookService : BookService, private router : Router) { }

  ngOnInit(): void {
    this.bookService.getBooks().subscribe((data:Book[])=>{
      console.log(data);
      this.books = data;
    });
  }

  updateBook(id : number | undefined) {
    this.router.navigate(["update-book", id]);
  }
}
