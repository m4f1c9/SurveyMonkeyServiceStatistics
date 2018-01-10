package org.jugru.monkeyStatistics.service;

import java.util.List;

import org.jugru.monkeyStatistics.model.chart.Chart;
import org.jugru.monkeyStatistics.model.chart.ChartsPreset;
import org.jugru.monkeyStatistics.util.IdNamePair;

/**
 *
 * @author A
 */
public interface ChartsPresetService extends Service<ChartsPreset> {

    Chart createChart(Long id, String type);

    List<Long> getChartsIdByPresetId(Long id);

    List<IdNamePair> getIdNamePairsOfChartsByPresetId(Long id);

    List<IdNamePair> getIdNamePairOfPresets();
}
