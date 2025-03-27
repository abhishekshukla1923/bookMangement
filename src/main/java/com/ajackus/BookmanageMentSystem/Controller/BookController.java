package com.ajackus.BookmanageMentSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ajackus.BookmanageMentSystem.entity.BookEntity;
import com.ajackus.BookmanageMentSystem.service.BookService;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("saveBook")
    public BookEntity saveBook(@RequestBody BookEntity book){
        return bookService.saveBook(book);
    }

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBooks();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @GetMapping("/search")
    public ResponseEntity<BookEntity> getBookByTitle(@RequestParam String title) {
        return bookService.getBookByTitle(title)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<BookEntity> updateBook(@PathVariable Long id, @RequestBody BookEntity book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/exit")
    public void exitApplication() {
        System.exit(0); 
    }

}
