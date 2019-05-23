package org.fasttrackit.runningstatsapi.web;


import org.fasttrackit.runningstatsapi.domain.RunningStats;
import org.fasttrackit.runningstatsapi.exception.ResourceNotFoundException;
import org.fasttrackit.runningstatsapi.service.RunningStatsService;
import org.fasttrackit.runningstatsapi.transfer.CreateRunningStatsRequest;
import org.fasttrackit.runningstatsapi.transfer.UpdateRunningStatsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/running-stats")
public class RunningStatsController {

    private final RunningStatsService runningStatsService;

    @Autowired
    public RunningStatsController(RunningStatsService runningStatsService) {
        this.runningStatsService = runningStatsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RunningStats> getRunningStats (@PathVariable("id") long id) throws ResourceNotFoundException {
        RunningStats response = runningStatsService.getRunningStats(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RunningStats> createRunningStats (@RequestBody @Valid CreateRunningStatsRequest request){
        RunningStats response = runningStatsService.createRunningStats(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity updateRunningStats(@PathVariable("id") long id, @RequestBody @Valid UpdateRunningStatsRequest request) throws ResourceNotFoundException {
        runningStatsService.updateRunningStats(id, request);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRunningStats(@PathVariable("id") long id ) {
        runningStatsService.deleteRunningStats(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }


}
