
package org.jugru.monkeyStatistics.repository;

import org.jugru.monkeyService.model.chart.Chart;
import org.jugru.monkeyService.model.chart.ChartsPreset;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChartRepository extends JpaRepository<Chart, Long> {

}
