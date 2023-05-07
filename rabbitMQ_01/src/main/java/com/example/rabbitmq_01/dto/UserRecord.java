package com.example.rabbitmq_01.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserRecord(@JsonProperty("id") int id, @JsonProperty("name") String name,
                         @JsonProperty("surname") String surname) {
}
