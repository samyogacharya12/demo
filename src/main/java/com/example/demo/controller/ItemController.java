package com.example.demo.controller;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ItemController {

    private final ItemService itemService;

    public  ItemController(ItemService itemService){
        this.itemService=itemService;

    }

    @PostMapping("/item")
    public ResponseEntity<?> save(@RequestBody Item item){
        item=itemService.save(item);
        return new ResponseEntity<>(item, HttpStatus.OK);

    }


}
