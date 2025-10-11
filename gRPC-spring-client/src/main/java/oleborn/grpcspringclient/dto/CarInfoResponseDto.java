package oleborn.grpcspringclient.dto;

import lombok.Builder;
import oleborn.grpc.common.CarStatus;

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