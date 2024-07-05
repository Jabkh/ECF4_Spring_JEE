package org.example.jobmanager.dto;


import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidateDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private List<ApplicationDTO> applications;
}