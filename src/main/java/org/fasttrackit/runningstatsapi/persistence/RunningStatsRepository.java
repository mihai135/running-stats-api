package org.fasttrackit.runningstatsapi.persistence;

import org.fasttrackit.runningstatsapi.domain.RunningStats;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RunningStatsRepository extends PagingAndSortingRepository<RunningStats, Long> {
}
