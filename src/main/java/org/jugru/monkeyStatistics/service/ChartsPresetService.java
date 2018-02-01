package org.jugru.monkeyStatistics.service;

import org.jugru.monkeyStatistics.model.chart.Chart;
import org.jugru.monkeyStatistics.model.chart.ChartsPreset;
import org.jugru.monkeyStatistics.util.IdNamePair;

import java.util.List;

/**
 *
 * @author A
 */
public interface ChartsPresetService extends Service<ChartsPreset> {

    Chart createChart(Long id, String type);

    List<Long> getChartsIdByPresetId(Long id);

    List<IdNamePair> getIdNamePairsOfChartsByPresetId(Long id);

    List<IdNamePair> getIdNamePairOfPresets();

    void rename(Long id, String name);
}
