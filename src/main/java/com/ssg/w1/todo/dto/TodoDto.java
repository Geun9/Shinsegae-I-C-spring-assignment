package com.ssg.w1.todo.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
    private Long id;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}

