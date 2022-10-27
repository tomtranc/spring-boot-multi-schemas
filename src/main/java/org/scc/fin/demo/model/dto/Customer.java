package org.scc.fin.demo.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Optional;

@Data
public class Customer {
    private String id;
    @NotEmpty
    @Pattern(regexp = "^\\w+$")
    private String name;
    private String description;
    private String metadata;
}
