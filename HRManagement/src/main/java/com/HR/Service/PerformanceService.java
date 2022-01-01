package com.HR.Service;

import com.HR.Bean.Performance;

public interface PerformanceService {

	Performance savePerfomance(Performance performance);
	Performance updatePerformance(Performance performance,long id);
	Performance getperformance(Long id);
	
}
