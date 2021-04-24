package com.central.main.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Table
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @Size(max = 100)
    private String level;

    @Column
    @NotNull
    @Size(max = 100)
    private String description;

    @Column
    @NotNull
    @Size(max = 255)
    private String log;

    @Column
    @NotNull
    @Size(max = 100)
    private String origin;

    @Column
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Timestamp eventDate;
}
