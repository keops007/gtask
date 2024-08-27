package com.run.gtask.repository;

import com.run.gtask.entity.EstimatedTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstimatedTimeRepository extends JpaRepository<EstimatedTime, Long> {
}
