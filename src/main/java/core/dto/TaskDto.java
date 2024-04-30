package core.dto;

import core.domains.Status;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class TaskDto {

    private String description;

    private Status status;
}
