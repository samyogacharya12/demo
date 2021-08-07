package com.example.demo.controller;

import com.example.demo.service.ItemService;
import com.example.demo.service.dto.ItemDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ItemController {

    private static final Logger log = LoggerFactory.getLogger(ItemController.class);

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;

    }

    @PostMapping("/item")
    public ResponseEntity<?> save(@RequestBody ItemDto item) {
        log.debug("Rest Request to save item");
        item = itemService.save(item);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/items")
    public ResponseEntity<?> findAll() {
        log.debug("Rest Request to retrieve item");
        return new ResponseEntity<>(itemService.findAll(), HttpStatus.OK);
    }

}
