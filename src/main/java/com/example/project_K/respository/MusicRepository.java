package com.example.project_K.respository;

import com.example.project_K.entity.Music;
import com.example.project_K.entity.testboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {
}
