package com.example.housing.HouseController;

import com.example.housing.House.House;
import com.example.housing.HouseServices.HouseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HouseController {
    @Autowired
    HouseServices houseServices;

    @PostMapping("addlist")
    public ResponseEntity<Void> addList(@RequestBody List<House> houses) {
        try{
            houseServices.addlist(houses);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("getall")
    public ResponseEntity<List<House>> getall() {
        try{
            List<House> houses = houseServices.getall();
            if(houses.size() == 0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.of(Optional.of(houses));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("getAvg")
    public ResponseEntity<String> getAvg(){
        try {
            double avg = houseServices.getAvg();
            if (avg == 0){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            String a = "Avg Is : " + avg;
            return ResponseEntity.of(Optional.of(a));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("getAvgByLocation")
    public ResponseEntity<List<Object[]>> getAvgByLocation(){
        try {
            List<Object[]> avg = (List<Object[]>) houseServices.getAvgByLocation();
            if (avg.size() == 0){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.of(Optional.of(avg));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("getMax")
    public ResponseEntity<String> getMax(){
        try {
            int max = houseServices.getMax();
            if (max == 0){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            String a ="Max Price Is : " + max;
            return ResponseEntity.of(Optional.of(a));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("getMin")
    public ResponseEntity<String> getMin(){
        try {
            int min = houseServices.getMin();
            if (min == 0){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            String a ="Min Price Is : " + min;
            return ResponseEntity.of(Optional.of(a));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("getByHn/{no}")
    public ResponseEntity<House> getByHn(@PathVariable("no") int no){
        try {
            House house = houseServices.getByHn(no);
            if (house == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.of(Optional.of(house));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
