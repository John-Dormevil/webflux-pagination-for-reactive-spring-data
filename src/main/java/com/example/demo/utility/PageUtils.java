package com.example.demo.utility;

import com.example.demo.utility.cimblo.PageImpl;
import com.example.demo.utility.cimblo.Page;
import java.util.List;
import org.apache.commons.lang3.tuple.MutablePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Cimblo.com
 * @version 2.0.0
 * @since 2.0.0 (22 Sep 2018)
 */
@Service
public class PageUtils {

  private ReactiveMongoTemplate reactiveMongoTemplate;

  @Autowired
  public void setReactiveMongoTemplate(ReactiveMongoTemplate reactiveMongoTemplate) {
    this.reactiveMongoTemplate = reactiveMongoTemplate;
  }

  public <T> Mono<Page<T>> toPage(Query query, Pageable pageable, Class<T> targetClass) {
    return reactiveMongoTemplate.count(
        query, targetClass
    ).map(aLong ->
        new MutablePair<List<T>, Long>(null, aLong)
    ).flatMap(pair ->
        reactiveMongoTemplate.find(query, targetClass).collectList().map(
            list -> {
              pair.setLeft(list);
              return pair;
            }
        ).flatMap(pagePair1 ->
            Mono.just((Page<T>) new PageImpl<>(pagePair1.getLeft(), pageable,
                pagePair1.getRight()))
        )
    ).single();
  }
}
