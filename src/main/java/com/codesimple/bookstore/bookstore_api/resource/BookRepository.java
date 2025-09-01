package com.codesimple.bookstore.bookstore_api.resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codesimple.bookstore.bookstore_api.entity.Book;

@Repository    //  give  inputs 1st is entity class and 2nd is data type of primary key of entity
public interface BookRepository extends CrudRepository<Book, Integer>{
	
//	CRUD - create, read update, delete oprations
//	save to db	
//	update the db
//	fetch from db
//	delete from db
	
	/*
	 *Spring support these from a special implementation 
	 *when give a book object into the repository class -> it store in the db -> when retrieve map into entity class and give back the list or string 
	 * */
	
	
}
