package com.clubproject.demo.dao;

import com.clubproject.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("userrepository")
public interface UserRepository extends JpaRepository<User, Integer>  {

}
