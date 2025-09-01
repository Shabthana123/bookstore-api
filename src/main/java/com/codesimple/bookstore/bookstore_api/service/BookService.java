package com.codesimple.bookstore.bookstore_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;

import com.codesimple.bookstore.bookstore_api.entity.Book;
import com.codesimple.bookstore.bookstore_api.resource.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
	public List<Book> getBooks(Set<Integer> yop, String bookType){
		
		List<Book> bookList = new ArrayList<>();
		
		if(yop == null) {
		
			bookRepository.findAll().forEach(book -> bookList.add(book));
		}
		else {
			return bookRepository.findAllByYearOfPublicationInAndBookType(yop,bookType);
		}
		
		
		
		return bookList;
		}
		
		
	//insert
	//single book insert
	public Book createBook(Book book) {
		
		// validate each field and save
		return bookRepository.save(book);
		
	}
	
	// insert list of books
	public List<Book> createBooks(List<Book> books){
		
		Iterable<Book> savedBooks = bookRepository.saveAll(books);
			
		List<Book> booksList = new ArrayList<>();
		
		savedBooks.forEach(book -> booksList.add(book));
		
		 return booksList;
	}
	
	public Book getBookbyId(Integer bookId) {
		
		return bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found with id: "+ bookId));
	}
	
	//update
	public Book updateBook(Book updatedContent) {
		
	
		return bookRepository.save(updatedContent);
		
			
	}
	//delete
	public String deleteBook(Integer bookId) {
		// TODO Auto-generated method stub
		
				
		bookRepository.deleteById(bookId);
		
		return "Book with id "+ bookId + " is successfully deleted";
	}


	//raw query - get books
	public List<Book> getBooksByRawQuery(Set<Integer> yop) {
		// TODO Auto-generated method stub
		List<Book> bookList = bookRepository.getBooksByYop(yop);
		return bookList;
	}
	
	
}
