package com.clubproject.demo.dao;

import com.clubproject.demo.entities.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("conversationrepository")
public interface ConversationRepository extends JpaRepository<Conversation, Integer>  {

}
