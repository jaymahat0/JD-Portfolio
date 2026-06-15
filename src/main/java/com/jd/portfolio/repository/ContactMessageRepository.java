package com.jd.portfolio.repository;

import com.jd.portfolio.entity.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactMessageRepository
        extends JpaRepository<ContactMessage, Long> {

    //List<ContactMessage> findByReadFalse();

    //long countByReadFalse();
}