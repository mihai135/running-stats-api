package org.fasttrackit.runningstatsapi;

import org.fasttrackit.runningstatsapi.domain.RunningStats;
import org.fasttrackit.runningstatsapi.exception.ResourceNotFoundException;
import org.fasttrackit.runningstatsapi.service.RunningStatsService;
import org.fasttrackit.runningstatsapi.transfer.CreateRunningStatsRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest

public class RunningStatsServiceIntegrationTests {

    @Autowired
    private RunningStatsService runningStatsService;

    @Test
    public void testCreateRunningStats_whenValidRequest_thenReturnRunningStatsWithId(){

        RunningStats runningStats = createRunningStats();

        assertThat(runningStats, notNullValue());
        assertThat(runningStats.getId(), greaterThan(0L));

    }

    private RunningStats createRunningStats() {
        CreateRunningStatsRequest request = new CreateRunningStatsRequest();
        request.setName("Mihai");
        request.setDistance_km(20);
        request.setTime_min(120);
        request.setTerrain("Forrest");

        return runningStatsService.createRunningStats(request);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetRuningStats_whenRunningStatsNotFound_thenThrowResourceNotFoundException() throws ResourceNotFoundException {
        runningStatsService.getRunningStats(0);

    }

    @Test
    public void testGetRunningStats_whenExistingId_thenReturnMatchingRunningStats() throws ResourceNotFoundException {
        RunningStats runningStats = createRunningStats();
        RunningStats retreivedRunningStats = runningStatsService.getRunningStats(runningStats.getId());

        assertThat(retreivedRunningStats.getId(), is(runningStats.getId()));
        assertThat(retreivedRunningStats.getName(), is(runningStats.getName()));


    }


}
