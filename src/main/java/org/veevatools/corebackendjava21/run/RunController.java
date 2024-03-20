package org.veevatools.corebackendjava21.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
            throw new RunNotFoundException(id);
        }
    }

    // post
    @PostMapping("/runs")
    @ResponseStatus(HttpStatus.CREATED)
    void create(@Valid @RequestBody Run run) {
        runRepository.create(run);
    }

    // put
    @PutMapping("/runs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@PathVariable Integer id, @Valid @RequestBody Run run) {
        runRepository.update(run, id);
    }

    // delete
    @DeleteMapping("/runs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Integer id) {
        runRepository.delete(id);
    }

}
