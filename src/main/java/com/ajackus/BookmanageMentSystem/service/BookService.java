package com.ajackus.BookmanageMentSystem.service;

import java.util.List;
import java.util.Optional;

import com.ajackus.BookmanageMentSystem.entity.BookEntity;
public interface BookService {
    public BookEntity saveBook(BookEntity book);
    public List<BookEntity> getAllBooks();
    public Optional<BookEntity> getBookById(Long bookId);
    public Optional<BookEntity> getBookByTitle(String title);
    public BookEntity updateBook(Long id, BookEntity updatedBook);
    public void deleteBook(Long id);

}
