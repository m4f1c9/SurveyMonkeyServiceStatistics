package org.jugru.monkeyStatistics.service.impl;

import org.jugru.monkeyStatistics.model.chart.Chart;
import org.jugru.monkeyStatistics.model.chart.GroupedByChoiceChart;
import org.jugru.monkeyStatistics.repository.ChartRepository;
import org.jugru.monkeyStatistics.service.ChartService;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ChartServiceImpl implements ChartService {

    private Logger logger = LoggerFactory.getLogger(ChartService.class);

    @Autowired
    SurveyService surveyService;

    @Autowired
    ChartRepository chartRepository;

    @Autowired
    ChartService chartService;

    @Override
    public Chart save(Chart t) {
        return chartRepository.save(t);
    }

    @Override
    public Chart get(long id) {
        Chart chart = chartRepository.findOne(id);
        // Hibernate удаляет последние null из @ElementCollection
        // тут я их восстанавливаю
        if(chart instanceof GroupedByChoiceChart){
            GroupedByChoiceChart c = (GroupedByChoiceChart) chart;
            int size = c.getQuestionDetails().size();
            c.getChoiceGroups().forEach(choiceGroup -> {
                while(choiceGroup.getChoicesId().size()<size){
                    choiceGroup.addChoiceId(null);
                }
            });
            chart = c;
        }

        return chart;
    }

    @Override
    public Chart getPreparedForSending(Long id) {
        Chart chart = chartService.get(id);
        chart.prepareForSending(surveyService);
        return chart;
    }

    @Override
    public void delete(Chart t) {
       chartRepository.delete(t);
    }

    @Override
    public List<Chart> getAll() {
        return chartRepository.findAll();
    }

}
