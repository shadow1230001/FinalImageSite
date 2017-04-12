package com.itransition.lyubin.repository;

import com.itransition.lyubin.model.Sex;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexRepository extends CrudRepository<Sex, Integer> {
}
