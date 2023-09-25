package com.gl.JPA.Assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.JPA.Assignment.entity.Book;
import com.gl.JPA.Assignment.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookrepo;
	public void addBook(Book b1)
	{
		bookrepo.save(b1);
	}
	
	public void deleteBook(int bno)
	{
		bookrepo.deleteById(bno);
	}

	public Book getBook(int bno) {
		
		return bookrepo.findById(bno).get();
	}

	public List<Book> getAllBooks() {
		
		return bookrepo.findAll();
	}

	public void updateBook(int bno, Book newBook) {
		Book dbbook=getBook(bno);
		dbbook.setAuthor(newBook.getAuthor());
		dbbook.setCategory(newBook.getCategory());
		dbbook.setTitle(newBook.getTitle());
		bookrepo.save(dbbook);
	}
}