package oleborn.grpcdevhclient.dto;

import com.grpc.common.CarStatus;
import lombok.Builder;

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