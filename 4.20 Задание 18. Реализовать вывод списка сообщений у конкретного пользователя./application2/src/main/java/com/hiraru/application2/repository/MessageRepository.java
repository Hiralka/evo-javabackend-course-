package com.hiraru.application2.repository;

import com.hiraru.application2.dto.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByPersonId(int personId);
}