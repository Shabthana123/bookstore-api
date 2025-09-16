package com.codesimple.bookstore.bookstore_api.resource;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codesimple.bookstore.bookstore_api.entity.Book;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

@Repository    //  give  inputs 1st is entity class and 2nd is data type of primary key of entity
public interface BookRepository extends CrudRepository<Book, Long>{
	
//	CRUD - create, read update, delete oprations
//	save to db	
//	update the db
//	fetch from db
//	delete from db
	
	/*
	 *Spring support these from a special implementation 
	 *when give a book object into the repository class -> it store in the db -> when retrieve map into entity class and give back the list or string 
	 * */
	
	List<Book> findAllByYearOfPublicationInAndBookType(Set<Integer> yop, String bookType);
	
//	String rawQuery = "select * from book where year_of_publication IN?1";
// or
	String rawQuery = "select * from book where year_of_publication in:YOP";

	@Query(nativeQuery = true, value = rawQuery)
//	List<Book> getBooksByYop(Set<Integer>yop);
	List<Book> getBooksByYop(@Param("YOP") Set<Integer>yop);
}
