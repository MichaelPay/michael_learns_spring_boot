package org.veevatools.corebackendjava21.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {

    private final List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id().equals(id))
                .findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        existingRun.ifPresent(value -> runs.set(runs.indexOf(value), run));
    }

    void delete(Integer id) {
        Optional<Run> existingRun = findById(id);
        existingRun.ifPresent(runs::remove);
    }


    @PostConstruct
    public void init() {
        runs.add(new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plusDays(1), 12, Location.INDOOR));
        runs.add(new Run(2, "Second Run", LocalDateTime.now(), LocalDateTime.now().plusDays(2), 15, Location.OUTDOOR));
        runs.add(new Run(3, "Third Run", LocalDateTime.now(), LocalDateTime.now().plusDays(3), 10, Location.INDOOR));
    }


}
