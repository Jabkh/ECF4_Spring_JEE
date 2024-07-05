package org.example.jobmanager.dto;


import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobOfferDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDate postedDate;
    private LocalDate closingDate;
    private List<ApplicationDTO> applications;
}