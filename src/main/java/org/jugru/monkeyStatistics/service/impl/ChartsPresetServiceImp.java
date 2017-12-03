package org.jugru.monkeyStatistics.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.jugru.monkeyService.model.chart.ChartsPreset;
import org.jugru.monkeyStatistics.repository.ChartsPresetRepository;
import org.jugru.monkeyStatistics.service.ChartsPresetService;
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

}
