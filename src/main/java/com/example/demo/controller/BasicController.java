package com.example.demo.controller;

import com.example.demo.entity.Basic;
import com.example.demo.utility.cimblo.Page;
import com.example.demo.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Cimblo.com
 * @version 2.0.0
 * @since 2.0.0 (22 Sep 2018)
 */
@RestController
@RequestMapping(value = "/basic")
public class BasicController {

  private final BasicService basicService;

  @Autowired
  public BasicController(BasicService basicService) {
    this.basicService = basicService;
  }

  @GetMapping("/all")
  public Mono<Page<Basic>> getEntitiesPage(
      @RequestParam(name = "page") int page,
      @RequestParam(name = "size") int size,
      @RequestParam(required = false) Sort sortDirection
  ) {
    return basicService.getAll(PageRequest.of(page, size));
  }

  @GetMapping("/init")
  public void init(){
    basicService.init();
  }
}
