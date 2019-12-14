package com.clubproject.demo.dao;

import com.clubproject.demo.entities.Enfant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface AppEnfantRepository extends JpaRepository<Enfant,Long> {
   // public Enfant findByusername(String username);
   public Enfant findById(long id);
   @CrossOrigin(origins = "*", allowedHeaders = "*")
   public List<Enfant> findByIdparent(long idparent);
}
