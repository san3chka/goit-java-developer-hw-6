package database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class LongestProject {
    private int projectId;
    private int clientId;
    private LocalDate startDate;
    private LocalDate finishDate;
    private int monthDuration;

}
