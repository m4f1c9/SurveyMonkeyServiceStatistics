package org.jugru.monkeyStatistics.service;

import java.util.List;
import org.jugru.monkeyService.model.chart.ChartsPreset;
import org.jugru.monkeyStatistics.util.IdNamePair;

/**
 *
 * @author A
 */
public interface ChartsPresetService extends Service<ChartsPreset> {

    List<Long> getChartsIdByPresetId(Long id);

    List<IdNamePair> getIdNamePairsByPresetId(Long id);
}
