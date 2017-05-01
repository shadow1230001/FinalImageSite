package com.itransition.lyubin.repository;


import com.itransition.lyubin.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    Tag findFirstByText(String text);
}
