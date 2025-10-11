package oleborn.restserver.domain.dto;

import java.time.Instant;

public record CarBuyRequestDto(
        String userName,
        long budget,
        Instant userBirthDate
) {}