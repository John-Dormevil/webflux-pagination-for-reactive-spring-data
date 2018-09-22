package com.example.demo.service;

import com.example.demo.entity.Basic;
import com.example.demo.utility.cimblo.Page;
import com.example.demo.repository.BasicRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author Cimblo.com
 * @version 2.0.0
 * @since 2.0.0 (22 Sep 2018)
 */
@Service
public class BasicServiceImpl implements BasicService {

  private final BasicRepository basicRepository;

  @Autowired
  public BasicServiceImpl(BasicRepository basicRepository) {
    this.basicRepository = basicRepository;
  }

  @Override
  public Mono<Page<Basic>> getAll(Pageable page) {
    return Mono.<Page<Basic>>create(emitter -> {
      Mono<Page<Basic>> result = basicRepository.findAll(page);
      result.subscribe(emitter::success);
    }).subscribeOn(Schedulers.elastic());
  }

  @Override
  public void init() {
    for (int i = 0; i < 1000; i++) {
      basicRepository.save(new Basic(null, "Name - "+i, "address - "+i, new Date())).block();
    }
  }
}
