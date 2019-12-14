package com.clubproject.demo.dao;

import com.clubproject.demo.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("messagerepository")
public interface MessageRepository extends JpaRepository<Message, Integer> {

}
