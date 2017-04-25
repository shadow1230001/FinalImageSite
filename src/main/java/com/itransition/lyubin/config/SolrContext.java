package com.itransition.lyubin.config;


import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

import javax.annotation.Resource;

/**
 * Created by User on 20.04.2017.
 */
@Configuration
@EnableSolrRepositories(basePackages = {"com.itransition.lyubin"}, multicoreSupport = true)
public class SolrContext {
    static final String SOLR_HOST = "solr.host";

    @Resource
    private Environment environment;

    @Bean
    public HttpSolrClient solrServer() {
        //String solrHost = environment.getRequiredProperty(SOLR_HOST);
        return new HttpSolrClient("localhost:8993");
    }
}
