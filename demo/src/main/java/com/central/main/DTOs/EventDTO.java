package com.central.main.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

    private Long id;
    private String level;
    private String description;
    private String origin;
    private Date eventDate;

}
