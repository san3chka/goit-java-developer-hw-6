package database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Data
@AllArgsConstructor
public class YoungestEldestWorker {
    private String type;
    private String name;
    private LocalDate birthday;
}
