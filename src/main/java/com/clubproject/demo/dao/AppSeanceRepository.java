package com.clubproject.demo.dao;

import com.clubproject.demo.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;

@RepositoryRestResource
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface AppSeanceRepository extends JpaRepository<Seance,Long> {
    public Seance findBydateseance(Date dateseance);
}
