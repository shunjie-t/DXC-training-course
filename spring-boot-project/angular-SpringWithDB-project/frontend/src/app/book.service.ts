import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from './book';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private baseUrl = "http://localhost:8081/book"
  constructor(private http : HttpClient) { }

  getBookById(id : number | undefined) : Observable<Book> {
    return this.http.get<Book>(`${this.baseUrl}/${id}`);
  }

  getBooks() : Observable<Book[]> {
    return this.http.get<Book[]>(`${this.baseUrl}`) ;
  }

  updateBook(id : number | undefined, book : Book) : Observable<object> {
    return this.http.put(`${this.baseUrl}/${id}`,book);
  }
}
