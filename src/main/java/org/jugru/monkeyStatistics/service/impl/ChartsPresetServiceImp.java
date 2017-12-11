package org.jugru.monkeyStatistics.service.impl;

import java.util.LinkedList;
import java.util.List;
import javax.transaction.Transactional;
import org.jugru.monkeyService.model.chart.ChartsPreset;
import org.jugru.monkeyStatistics.repository.ChartsPresetRepository;
import org.jugru.monkeyStatistics.service.ChartsPresetService;
import org.jugru.monkeyStatistics.util.IdNamePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ChartsPresetServiceImp implements ChartsPresetService {

    @Autowired
    ChartsPresetRepository chartsPresetRepository;

    @Override
    public ChartsPreset save(ChartsPreset t) {
        return chartsPresetRepository.save(t);
    }

    @Override
    public ChartsPreset get(long id) {
        return chartsPresetRepository.findOne(id);
    }

    @Override
    public void delete(ChartsPreset t) {
        chartsPresetRepository.delete(t);
    }

    @Override
    public List<ChartsPreset> getAll() {
        return chartsPresetRepository.findAll();
    }

    @Override
    public List<Long> getChartsIdByPresetId(Long id) {
        List<Long> answer = new LinkedList<>();
        get(id).getCharts().forEach((t) -> {
            answer.add(t.getId());
        });
        return answer;
    }

    @Override
    public List<IdNamePair> getIdNamePairsByPresetId(Long id) {
        List<IdNamePair> answer = new LinkedList<>();
        get(id).getCharts().forEach((t) -> {
            answer.add(new IdNamePair(t.getId(), t.getChartName()));
        });
        return answer;
    }

}
