package org.jugru.monkeyStatistics.repository;

import org.jugru.monkeyService.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

    
}
