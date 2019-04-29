package org.fasttrackit.runningstatsapi;

import org.fasttrackit.runningstatsapi.domain.RunningStats;
import org.fasttrackit.runningstatsapi.exception.ResourceNotFoundException;
import org.fasttrackit.runningstatsapi.service.RunningStatsService;
import org.fasttrackit.runningstatsapi.transfer.CreateRunningStatsRequest;
import org.fasttrackit.runningstatsapi.transfer.UpdateRunningStatsRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.ZoneId;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
        CreateRunningStatsRequest request = new CreateRunningStatsRequest(60,8.5);
        request.setName("Cosmin");
        request.setDate(LocalDate.now(ZoneId.of("Europe/Bucharest")).plusDays(1));
        request.setTerrain("Hill");

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

    @Test
    public void testUpdateRunningStats_whenValidRequestWithAllFields_thenReturnUpdatedRunningStats() throws ResourceNotFoundException {
        RunningStats createdRunningstats = createRunningStats();
        UpdateRunningStatsRequest request = new UpdateRunningStatsRequest();
        request.setName(createdRunningstats.getName()+"edited");
        request.setDate(createdRunningstats.getDate());
        request.setDistance_km(createdRunningstats.getDistance_km() + 5);
        request.setTime_min(createdRunningstats.getTime_min() + 3);
        request.setTerrain(createdRunningstats.getTerrain()+"edited");

        RunningStats updatedRunningStats = runningStatsService.updateRunningStats(createdRunningstats.getId(), request);

        assertThat(updatedRunningStats.getName(), is (request.getName()));
        assertThat(updatedRunningStats.getName(), not (is (request.getName())));
        assertThat(updatedRunningStats.getDate(), is (request.getDate()));
        assertThat(updatedRunningStats.getDistance_km(), is (request.getDistance_km()));
        assertThat(updatedRunningStats.getTime_min(), is (request.getTime_min()));
        assertThat(updatedRunningStats.getTerrain(), is (request.getTerrain()));
        assertThat(updatedRunningStats.getId(), is (createdRunningstats.getId()));

    }

    @Test(expected = ResourceNotFoundException.class)
    public void testDeleteRunningStats_whenExsistingId_thenRunningStatsIsDeleted() throws ResourceNotFoundException {
        RunningStats createdRunningstats = createRunningStats();
        runningStatsService.deleteRunningStats(createdRunningstats.getId());
        runningStatsService.getRunningStats(createdRunningstats.getId());
    }


}
