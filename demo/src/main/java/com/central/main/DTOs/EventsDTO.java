package com.central.main.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EventsDTO {

    private Long id;
    private String level;
    private String description;
    private String origin;
    private Timestamp eventDate;

}
