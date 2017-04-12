package com.itransition.lyubin.repository;

import com.itransition.lyubin.model.Sex;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexRepository extends CrudRepository<Sex, Long> {
    @Query(value = "FROM Sex as p WHERE p.id = ?1")
    Sex findById(Integer id);

}
