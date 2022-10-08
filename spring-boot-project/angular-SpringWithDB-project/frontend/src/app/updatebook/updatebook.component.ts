import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-updatebook',
  templateUrl: './updatebook.component.html',
  styleUrls: ['./updatebook.component.css']
})
export class UpdatebookComponent implements OnInit {

  book : Book = new Book();
  id : number | undefined;

  constructor(private bookService : BookService, private route : ActivatedRoute, private router : Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params["id"];
    this.bookService.getBookById(this.id).subscribe(data => {
      this.book = data;
    });
  }

  onSubmit() {
    this.bookService.updateBook(this.id,this.book).subscribe(data => {
      this.goToBookList();
    });
  }

  goToBookList() {
    this.router.navigate(["/book"]);
  }
}
