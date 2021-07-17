package com.example.demo.service;

import com.example.demo.Entity.Item;
import com.example.demo.Exception.BadRequestException;
import com.example.demo.Repository.ItemRepository;
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
