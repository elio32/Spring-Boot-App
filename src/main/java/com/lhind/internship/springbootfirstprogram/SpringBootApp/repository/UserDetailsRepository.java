package com.lhind.internship.springbootfirstprogram.SpringBootApp.repository;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {
}
