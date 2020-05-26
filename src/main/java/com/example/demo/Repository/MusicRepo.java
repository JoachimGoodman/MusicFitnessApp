package com.example.demo.Repository;

import com.example.demo.Model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//Reposity til behandling af musik. Intet er sat op men det kan nemt gøres i fremtiden.
//Det er sat op med JPA.
@Repository
public interface MusicRepo extends JpaRepository<Music,Integer> {
}
