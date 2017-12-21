package org.jugru.monkeyStatistics.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.jugru.monkeyStatistics.model.chart.Chart;
import org.jugru.monkeyStatistics.model.chart.GroupedByChoiceChart;
import org.jugru.monkeyStatistics.repository.ChartRepository;
import org.jugru.monkeyStatistics.service.ChartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ChartServiceImpl implements ChartService {

    Logger logger = LoggerFactory.getLogger(ChartService.class);

    @Autowired
    ChartRepository chartRepository;

    @Override
    public Chart save(Chart t) {
        logger.debug("{}",  t);
        return chartRepository.save(t);
    }


    @Override
    public Chart get(long id) {
        Chart chart = chartRepository.findOne(id);
        logger.debug("{}", chart);



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
    public void delete(Chart t) {
       chartRepository.delete(t);
    }

    @Override
    public List<Chart> getAll() {
        return chartRepository.findAll();
    }

}
