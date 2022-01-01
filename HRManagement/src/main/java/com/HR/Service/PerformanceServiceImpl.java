package com.HR.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.HR.Bean.Performance;
import com.HR.Exception.ResourceNotFoundException;
import com.HR.Repository.PerformanceRepository;

public class PerformanceServiceImpl implements PerformanceService{
	
	@Autowired
	private PerformanceRepository performanceRepository;

	@Override
	public Performance savePerfomance(Performance performance) {
		return performanceRepository.save(performance);
	}
	
	@Override
	public Performance updatePerformance(Performance performance, long id) {
	
		Performance performance2=performanceRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Performance","ID", id));
		
		performance2.setComment(performance.getComment());
		performance2.setRating(performance.getRating());
		
		performanceRepository.save(performance2);
		return performance2;
	}
	
	@Override
	public Performance getperformance(Long id) {
		Optional<Performance> perOptional = performanceRepository.findById(id);
		if(perOptional.isPresent())
		{
			return perOptional.get();
		}
		else
		{
			throw new ResourceNotFoundException("Performance","Id", id);
		}		
	}
}
