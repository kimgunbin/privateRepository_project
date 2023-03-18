package com.example.project_K.respository;
import com.example.project_K.entity.testboard;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository                                         //어떤엔티티를 넣을것이냐, 엔티티의 id의 타입
public interface BoardRepository extends JpaRepository<testboard, Integer> {

}