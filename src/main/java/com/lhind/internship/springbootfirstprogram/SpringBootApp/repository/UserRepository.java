package com.lhind.internship.springbootfirstprogram.SpringBootApp.repository;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "SELECT * FROM User  JOIN Flight  WHERE Flight.id = :flightId",nativeQuery = true)
    List<User> findUsersByFlightId(@Param("flightId") Long flightId);

    Optional<User> findByUsername(String username);
}
