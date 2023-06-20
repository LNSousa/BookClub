package com.lsousa.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsousa.bookclub.models.Book;
import com.lsousa.bookclub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
    private BookRepository repo;
	
	// ========== Create / Update ================

    public Book save(Book m) {
        return repo.save(m);
    }

// ========== Read ===========================

    public List<Book> getAll() {
        return repo.findAll();
    }

    public Book getOne (Long id) {
        return repo.findById(id).orElse(null);
    }

// ========== Delete =========================

    public void deleteOne (Long id) {
        repo.deleteById(id);
    }
}
