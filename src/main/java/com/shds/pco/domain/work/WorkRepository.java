package com.shds.pco.domain.work;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkRepository extends JpaRepository<Work, Long> {

    @Query("SELECT p FROM Work p ORDER BY p.idx DESC")
    List<Work> findAllDesc();
}
