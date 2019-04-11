package org.fasttrackit.runningstatsapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.runningstatsapi.domain.RunningStats;
import org.fasttrackit.runningstatsapi.exception.ResourceNotFoundException;
import org.fasttrackit.runningstatsapi.persistence.RunningStatsRepository;
import org.fasttrackit.runningstatsapi.transfer.CreateRunningStatsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunningStatsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RunningStatsService.class);
    private final RunningStatsRepository runningStatsRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public RunningStatsService(RunningStatsRepository runningStatsRepository, ObjectMapper objectMapper) {

        this.runningStatsRepository = runningStatsRepository;
        this.objectMapper = objectMapper;
    }

    public RunningStats createRunningStats (CreateRunningStatsRequest request){
        LOGGER.info(" Creating running record {}", request);
        RunningStats runningStats = objectMapper.convertValue(request, RunningStats.class);
        return runningStatsRepository.save(runningStats);

    }

    public RunningStats getRunningStats (long id) throws ResourceNotFoundException {
        LOGGER.info(" Retreiving running record {}", id);
        return runningStatsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Record" + id + "not found"));
    }


}
