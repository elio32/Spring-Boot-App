package com.lhind.internship.springbootfirstprogram.SpringBootApp.repository;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.User;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findAllByUserDetails(UserDetails userDetails);
    @Query(value = "SELECT * FROM User  JOIN Flight  WHERE Flight .id = :flightId",nativeQuery = true)
    List<User> findUsersByFlightId(@Param("flightId") Long flightId);
}
