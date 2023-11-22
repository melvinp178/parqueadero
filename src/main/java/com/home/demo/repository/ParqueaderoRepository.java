package com.home.demo.repository;

import com.home.demo.entity.Parqueadero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParqueaderoRepository extends JpaRepository<Parqueadero, Long> {
}
