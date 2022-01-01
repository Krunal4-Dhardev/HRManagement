package com.HR.Repository;

import org.springframework.stereotype.Repository;

import com.HR.Bean.Performance;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long>
{
	
}
