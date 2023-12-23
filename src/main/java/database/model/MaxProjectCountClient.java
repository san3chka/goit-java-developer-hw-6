package database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
public class MaxProjectCountClient {
    private String name;
    private int projectCount;
}
