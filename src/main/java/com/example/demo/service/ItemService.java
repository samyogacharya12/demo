package com.example.demo.service;

import com.example.demo.service.dto.ItemDto;

import java.util.List;

public interface ItemService {

    ItemDto save(ItemDto item);

    List<ItemDto> findAll();
}
