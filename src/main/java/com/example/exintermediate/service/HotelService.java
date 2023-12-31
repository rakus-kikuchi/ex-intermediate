package com.example.exintermediate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exintermediate.domain.Hotel;
import com.example.exintermediate.repository.HotelRepository;

@Service
@Transactional
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> hotelList(Integer price){
        return hotelRepository.hotelList(price);
    }
}
