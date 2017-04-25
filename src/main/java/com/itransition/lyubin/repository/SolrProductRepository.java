package com.itransition.lyubin.repository;

import com.itransition.lyubin.model.Profile;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * Created by User on 21.04.2017.
 */
public interface SolrProductRepository extends SolrCrudRepository<Profile, Integer> {

}
