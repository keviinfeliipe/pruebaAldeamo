package com.aldeamo.prueba.model.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RequestDTO {
    private int iteration;
    private int index;
}
