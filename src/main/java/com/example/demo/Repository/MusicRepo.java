package com.example.demo.Repository;

import com.example.demo.Model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepo extends JpaRepository<Music,Integer> {
}
