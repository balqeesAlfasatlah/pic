package com.example.pic.repository;

import com.example.pic.models.CatPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PicRepository extends JpaRepository<CatPicture,Long> {
    CatPicture findById(long id);
}
