package com.example.demo.service;

import com.example.demo.entity.Item;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.ItemRepository;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class ItemServiceImpl implements ItemService {


    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository=itemRepository;
    }

    @Override
    public Item save(Item item) {
        if(Objects.nonNull(itemRepository.findByName(item.getName()))){
            throw new BadRequestException("Item Name Already Exist", item);
        }
        return itemRepository.save(item);
    }
}
