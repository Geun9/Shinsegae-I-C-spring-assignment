package com.ssg.w1.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private int id;
    private String title;
    private String dueDate;
    private String status;
}

