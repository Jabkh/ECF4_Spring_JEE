package org.example.jobmanager.dto;


import lombok.*;

import java.time.LocalDate;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InterviewDTO {
    private Long id;
    private LocalDate interviewDate;
    private String interviewer;
    private String interviewType;
    private ApplicationDTO application;
}