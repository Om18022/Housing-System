package com.example.housing.HouseRepo;

import com.example.housing.House.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepo extends JpaRepository<House, Integer> {
    @Query("select AVG(salePrice) from House")
    double getAvgPrice();

    @Query("select location, AVG(salePrice) from House  group by location")
    List<Object[]> getAvgByLocation();

    @Query("select MAX(salePrice) from House")
    int getMax();

    @Query("select MIN(salePrice) from House")
    int getMin();
}
