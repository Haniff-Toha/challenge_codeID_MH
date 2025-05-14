package com.codeid.eshopay.model.response;

import java.time.Instant;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;
    
    @Builder.Default
    private Instant timestamp = Instant.now();

    // Constructors
    // public ApiResponse(String status, String message, T data) {
    //     this.status = status;
    //     this.message = message;
    //     this.data = data;
    //     this.timestamp = Instant.now();
    // }

    


}
