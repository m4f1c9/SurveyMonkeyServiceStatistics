package org.jugru.monkeyStatistics.service;

import org.jugru.monkeyStatistics.model.Question;

public interface QuestionService extends Service<Question>{
    /**
     * Считает каличестве уникальных ответов
     * 
     */
    int countByQuestionMetaInformationId(Long id);
    
    
}
