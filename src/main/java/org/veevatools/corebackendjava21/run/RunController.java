package org.veevatools.corebackendjava21.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RunController {

    @GetMapping("/run")
    Run getRun() {
        return new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plusDays(1), 12, Location.INDOOR);
    }

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("/runs")
    List<Run> findAll() {
        return runRepository.findAll();
    }

    @GetMapping("/runs/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);

        if (run.isPresent()) {
            return run.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run not found");
        }
    }

    // post

    // put

    // delete

}
