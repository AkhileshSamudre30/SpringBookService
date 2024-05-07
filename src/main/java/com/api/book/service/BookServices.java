package com.api.book.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Service
public class BookServices {
	
	@Autowired
	private BookRepository bookRepository;
	
//	private static List<Book> list = new ArrayList<>();
//	
//	static {
//		
//		list.add(new Book(12, "Java Complete Refrance","ABC"));
//		
//		list.add(new Book(133, "Css Complete Refrance","xyz"));
//		
//		list.add(new Book(90, "Python Complete Refrance","lmn"));
//	}
	
	
	public List<Book> getAllBooks(){

		
		List<Book> list = (List<Book>)this.bookRepository.findAll();
		
		
		return list; 
		
	}
	
	
	public Book getBookById(int id) {
	    
	   Book  book = null; 
		
		try {
			
			this.bookRepository.findById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return book; 
		
	}
	
	
	public Book addBook(Book b) {
       
		
		Book result = this.bookRepository.save(b);
		
     	return result; 
	
	}

	
	
	 public void deleteBook(int bookId) {
		 
		 
		this.bookRepository.deleteById(bookId);
		 
		 
	 }
	 
	 
	 public  void updateBook(Book book , int bookId) {
		 
//		 list = list.stream().map(b->{
//			 
//			 
//			 if (b.getId()==bookId) {
//				 
//				 b.setName(book.getName());
//				 b.setAuthor(book.getAuthor());
//				
//			}
//			 return b;
// 
//		 }).collect(Collectors.toList());
//		 
		 book.setId(bookId);
		 
		 this.bookRepository.save(book);
		 
		 
	 }
	 
}
