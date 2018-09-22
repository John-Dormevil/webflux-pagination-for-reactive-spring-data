package com.example.demo.repository;

import com.example.demo.entity.Basic;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Cimblo.com
 * @version 2.0.0
 * @since 2.0.0 (22 Sep 2018)
 */
@Repository
public interface BasicRepository extends ReactiveMongoRepository<Basic, String>, BasicRepositoryCustom {}
