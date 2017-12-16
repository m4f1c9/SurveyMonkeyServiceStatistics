
package org.jugru.monkeyStatistics.repository;

import org.jugru.monkeyStatistics.model.chart.Chart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChartRepository extends JpaRepository<Chart, Long> {

}
