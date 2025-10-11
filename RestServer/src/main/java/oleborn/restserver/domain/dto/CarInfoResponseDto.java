package oleborn.restserver.domain.dto;

import lombok.Builder;
import oleborn.restserver.controller.CarStatus;

import java.util.List;
import java.util.Map;

@Builder
public record CarInfoResponseDto(
        long id,
        String modelName,
        int yearCreated,
        List<String> details,
        Map<String, String> metadata,
        CarStatus carStatus
) {}