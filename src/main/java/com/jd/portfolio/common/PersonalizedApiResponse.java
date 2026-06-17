package com.jd.portfolio.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Schema(description = "Standard API Response wrapper")
public class PersonalizedApiResponse<T> {

    @Schema(
            description = "Operation Status",
            example = "true"
    )
    private boolean success;

    @Schema(
            description = "Response message",
            example = "Resource fetched successfully"
    )
    private String message;

    @Schema(
            description = "Fetched Data"
    )
    private T data;
}
