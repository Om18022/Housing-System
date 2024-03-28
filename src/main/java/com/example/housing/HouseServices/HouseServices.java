package com.example.housing.HouseServices;

import com.example.housing.House.House;
import com.example.housing.HouseRepo.HouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServices {

    @Autowired
    HouseRepo houseRepo;

    public void addlist(List<House> houses) {
        houseRepo.saveAll(houses);
    }

    public List<House> getall() {
        return houseRepo.findAll();
    }

    public double getAvg() {
        return houseRepo.getAvgPrice();
    }

    public List<Object[]> getAvgByLocation() {
        return (List<Object[]>) houseRepo.getAvgByLocation();
    }

    public int getMax() {
        return houseRepo.getMax();
    }

    public int getMin() {
        return houseRepo.getMin();
    }

    public House getByHn(int no) {
        return houseRepo.findById(no).get();
    }
}
