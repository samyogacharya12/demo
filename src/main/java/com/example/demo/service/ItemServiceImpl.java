package com.example.demo.service;

import com.example.demo.controller.ItemController;
import com.example.demo.entity.Item;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.dto.ItemDto;
import com.example.demo.service.mapper.ItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger log = LoggerFactory.getLogger(ItemController.class);


    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    public ItemServiceImpl(ItemRepository itemRepository,
                           ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public ItemDto save(ItemDto itemDto) {
        log.debug("Saving Item");
        if (Objects.nonNull(itemRepository.findByName(itemDto.getName()))) {
            throw new BadRequestException("Item Name Already Exist", itemDto);
        }
        Item item = itemMapper.toEntity(itemDto);
        return itemMapper.toDto(itemRepository.save(item));
    }

    @Override
    public List<ItemDto> findAll() {
        log.debug("Finding All Items");
        AtomicInteger index = new AtomicInteger(1);
        List<ItemDto> itemDtos = itemRepository.findAll().stream()
                .map(itemMapper::toDto).collect(Collectors.toList());
        itemDtos.forEach(itemDto -> {
            int value = itemDto.compareTo(itemDtos.get(index.get()));
            if (value < 0) {
                log.info(itemDto.getName() + " Comes Before " +
                        itemDtos.get(index.get()).getName());
            } else if (value > 0) {
                log.info(itemDtos.get(index.get()).getName() +
                        " Comes after " + itemDto.getName());
            } else {
                log.info(itemDto.getName() +
                        " is equal  to " + itemDtos.get(index.get()).getName());
            }
            if (index.get() < itemDtos.size()-1) {
                index.getAndIncrement();
            }
        });
        return itemDtos;
    }
}
