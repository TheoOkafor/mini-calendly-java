package com.miniCalendly.repository;

import com.miniCalendly.model.Opening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpeningRepository extends JpaRepository<Opening, Long> {
    List<Opening> findAllByOwner(Long owner);
}
