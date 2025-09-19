package com.codesimple.bookstore.bookstore_api.resource;

import org.springframework.data.repository.CrudRepository;

import com.codesimple.bookstore.bookstore_api.entity.BookAuthor;

public interface BookAuthorRepository extends CrudRepository<BookAuthor, Long>{

}
