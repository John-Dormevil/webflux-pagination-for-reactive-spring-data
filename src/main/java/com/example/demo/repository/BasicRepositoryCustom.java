package com.example.demo.repository;

import com.example.demo.entity.Basic;
import com.example.demo.utility.cimblo.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

/**
 * @author Cimblo.com
 * @version 2.0.0
 * @since 2.0.0 (22 Sep 2018)
 */
public interface BasicRepositoryCustom {

  Mono<Page<Basic>> findAll(Pageable pageable);
}
