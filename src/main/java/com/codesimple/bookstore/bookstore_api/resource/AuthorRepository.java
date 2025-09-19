package com.codesimple.bookstore.bookstore_api.resource;


import org.springframework.data.repository.CrudRepository;

import com.codesimple.bookstore.bookstore_api.entity.Book;


public interface AuthorRepository extends CrudRepository<Book, Long>{
	
	
}
