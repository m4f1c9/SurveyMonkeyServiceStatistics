package org.jugru.monkeyStatistics.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.jugru.monkeyService.model.chart.Chart;
import org.jugru.monkeyStatistics.repository.ChartRepository;
import org.jugru.monkeyStatistics.service.ChartService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ChartServiceImpl implements ChartService {

    @Autowired
    ChartRepository chartRepository;

    @Override
    public Chart save(Chart t) {
        return chartRepository.save(t);
    }

    @Override
    public Chart get(long id) {
        return chartRepository.findOne(id);
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
