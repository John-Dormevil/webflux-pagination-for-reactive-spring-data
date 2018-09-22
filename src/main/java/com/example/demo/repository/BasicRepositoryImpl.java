package com.example.demo.repository;

import com.example.demo.utility.PageUtils;
import com.example.demo.entity.Basic;
import com.example.demo.utility.cimblo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author Cimblo.com
 * @version 2.0.0
 * @since 2.0.0 (22 Sep 2018)
 */
@Repository
public class BasicRepositoryImpl implements BasicRepositoryCustom{

  @Autowired
  private PageUtils pageUtils;

  @Override
  public Mono<Page<Basic>> findAll(Pageable pageable) {
    Query query = new Query();
    query.with(pageable);
    return pageUtils.toPage(query, pageable, Basic.class);
  }
}
