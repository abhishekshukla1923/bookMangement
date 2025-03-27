package com.ajackus.BookmanageMentSystem.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajackus.BookmanageMentSystem.entity.AvaliabilityStatusEnum;
import com.ajackus.BookmanageMentSystem.entity.BookEntity;
import com.ajackus.BookmanageMentSystem.repository.BookRepository;
@Service
public class BookServiceImplementation  implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookEntity saveBook(BookEntity book) {
        book.setId(generateSixDigitId());
        book.setAvailabilityStatus(AvaliabilityStatusEnum.AVALIABLE);
        return bookRepository.save(book);
    }

    private Long generateSixDigitId() {
        long num = Math.abs(UUID.randomUUID().getMostSignificantBits());
        return num % 900000 + 100000;
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
        
    }

    @Override
    public Optional<BookEntity> getBookById(Long bookId) {
        return bookRepository.findById(bookId);
        
    }

    @Override
    public Optional<BookEntity> getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
        
    }

    @Override
    public BookEntity updateBook(Long id, BookEntity updatedBook) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setGenre(updatedBook.getGenre());
            book.setAvailabilityStatus(updatedBook.getAvailabilityStatus());
            return bookRepository.save(book);
        }).orElseThrow(() -> new RuntimeException("Book not found"));
        
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    

    
        
    

}
