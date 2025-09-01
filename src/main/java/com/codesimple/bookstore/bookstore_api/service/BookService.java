package com.codesimple.bookstore.bookstore_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesimple.bookstore.bookstore_api.entity.Book;
import com.codesimple.bookstore.bookstore_api.resource.BookRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service    // when state @service annotation spring automatically create a object for that and manage that so in other package/class no need to use new too create object. can use directly
public class BookService {
	// here do the things which basically done in table or database
	
	@Autowired
	private BookRepository bookRepository;
	
	//db call
	// but here i call manually to check
//	static List<Book> bookList = Arrays.asList(
//			new Book(1,"2nd world war", "description of 2nd world war", 1887, "fiction"),
//			new Book(2,"Sri Lankan Ecconomy", "Sri Lankan Ecconomy", 2010, "nonfiction"),
//			new Book(3,"Time is Mony", "description of important of time", 2004, "fiction")
//			);
	
			
	//view or get or read 
	public List<Book> getBooks(){
		
		List<Book> bookList = new ArrayList<>();
		
		bookRepository.findAll().forEach(book -> bookList.add(book));
		
		
		return bookList;
		}
		
		
	//create
	
	//update
	
	//delete
	
	
}
