package org.jugru.monkeyStatistics.service;

import org.jugru.monkeyStatistics.model.chart.Chart;

/**
 *
 * @author A
 */
public interface ChartService extends Service<Chart> {
    Chart getPreparedForSending(Long id);
}
