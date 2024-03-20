package org.veevatools.corebackendjava21.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
    Integer id,
    @NotEmpty
    String title,
    @NotNull
    LocalDateTime startedOn,
    @NotNull
    LocalDateTime completedOn,
    @NotNull
    @Positive
    Integer miles,
    @NotNull
    Location location
) {
    public Run {
        if (startedOn.isAfter(completedOn)) {
            throw new IllegalArgumentException("completedOn must be after startedOn");
        }
    }
}
