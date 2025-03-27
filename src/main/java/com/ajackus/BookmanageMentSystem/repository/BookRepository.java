package com.ajackus.BookmanageMentSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajackus.BookmanageMentSystem.entity.AvaliabilityStatusEnum;
import com.ajackus.BookmanageMentSystem.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
    Optional<BookEntity> findByTitle(String title); 

    List<BookEntity> findByAvailabilityStatus(AvaliabilityStatusEnum status);


}
