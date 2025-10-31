package com.rang.rangaudiovisualbackend.dto;

import java.time.LocalDateTime;

public record EventDTO (Long id, String name, LocalDateTime date, String location){
}
