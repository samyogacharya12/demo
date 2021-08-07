package com.example.demo.service.dto;

import java.io.Serializable;

public class ItemDto implements Serializable, Comparable<ItemDto> {


    private Long id;

    private String name;

    private String features;

    private Double amount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(ItemDto other) {
        if (getAmount() > other.getAmount()) {
            return 1;
        } else if (getAmount() < other.getAmount()) {
            return -1;
        } else {
            return 0;
        }
    }
}
