package com.ajackus.BookmanageMentSystem.entity;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class BookEntity {
    @Id
   
   private Long id;  
   
   @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String author;
    
    private String genre;
    @Column(nullable = false)
    private AvaliabilityStatusEnum availabilityStatus;
    
    
    


}
