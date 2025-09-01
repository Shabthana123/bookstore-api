package com.codesimple.bookstore.bookstore_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codesimple.bookstore.bookstore_api.entity.Book;
import com.codesimple.bookstore.bookstore_api.service.BookService;


import java.util.List;

@RestController
public class BookController {
	
	// to make sure this is the object created by service annotation
	@Autowired
	private BookService bookService; 
	
	@RequestMapping(value = "/books")
	public List<Book> getBooks(){
		
//		//db call
//		// but here i call manually to check
//		List<Book> bookList = Arrays.asList(
//				new Book(1,"2nd world war", "description of 2nd world war", 1887, "fiction"),
//				new Book(2,"Sri Lankan Ecconomy", "Sri Lankan Ecconomy", 2010, "nonfiction"),
//				new Book(3,"Time is Mony", "description of important of time", 2004, "fiction")
//				);
				
				
				
		return bookService.getBooks();
	}
	
	// need to state in the input    as from where it will get ex: request body
	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public Book createBook(@RequestBody Book book) {
		
		return bookService.createBook(book);
	}
	
	//multiple books insert 
	@RequestMapping(value = "/books/batch", method = RequestMethod.POST)
	public List<Book> createBooks(@RequestBody List<Book> books){
		
		return bookService.createBooks(books);
	}
	
	@RequestMapping(value = "/books/{id}")
	public Book getBook(@PathVariable("id") Integer bookId) {
		 
		return bookService.getBookbyId(bookId);
	}

}
