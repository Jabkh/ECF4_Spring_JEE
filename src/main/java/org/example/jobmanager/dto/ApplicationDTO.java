package org.example.jobmanager.dto;


import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationDTO {
    private Long id;
    private String candidateName;
    private String candidateEmail;
    private LocalDate applicationDate;
    private JobOfferDTO jobOffer;
    private List<InterviewDTO> interviews;
}