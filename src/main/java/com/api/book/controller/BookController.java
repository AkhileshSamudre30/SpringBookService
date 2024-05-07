package com.api.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.api.book.entities.Book;
import com.api.book.service.BookServices;

@RestController
public class BookController {
	
	@Autowired
	private BookServices bookServices;
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		return this.bookServices.getAllBooks();
		
	}
	
	
	@GetMapping("books/{id}")
	public Book getBookById(@PathVariable() int id) {
		
		return this.bookServices.getBookById(id);
		
	}
	
    
	@PostMapping("/books")
	public Book addBook(@RequestBody  Book b) {
		
		
		Book addBook = this.bookServices.addBook(b);
		System.out.println(addBook);
		return addBook;
	}
	
	
	@DeleteMapping("/books/{bookId}")
	public  void deleteBook(@PathVariable()int bookId) {
		
		
		 this.bookServices.deleteBook(bookId);
		
		
	}

	@PutMapping("/books/{bookId}")
	public  Book  updateBookById(@RequestBody Book book , @PathVariable("bookId") int bookId ) {
		
		
		this.bookServices.updateBook(book, bookId);
		
		return book; 
	}
	
	

}
