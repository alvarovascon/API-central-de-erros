package com.central.main.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventPage {
    private int pageNumber = 0;
    private int pageSize = 3;
    private Sort.Direction direction = Sort.Direction.ASC;
    private String sortBy = "id";

}
