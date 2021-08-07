package com.example.demo.service.mapper;

import com.example.demo.entity.Item;
import com.example.demo.service.dto.ItemDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring", uses = {})
public interface ItemMapper extends EntityMapper<ItemDto, Item> {
}
