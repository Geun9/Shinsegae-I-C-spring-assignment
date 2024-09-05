package com.ssg.w1.todo.service;

import com.ssg.w1.todo.dto.TodoDto;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
    INSTANCE;

    public void register(TodoDto dto){
        System.out.println("DEBUG............." + dto);
    }

    // 등록된 글
    public List<TodoDto> getList() {
        List<TodoDto> todoDtos = IntStream.range(0, 10).mapToObj(i -> {
            TodoDto dto = new TodoDto();

            dto.setId((long) i);
            dto.setTitle("Todo..." + i);
            dto.setDueDate(LocalDate.now());


            return dto;
        }).collect(Collectors.toList());
        return todoDtos;
    }

    public TodoDto get(Long id) {
        TodoDto dto = new TodoDto();
        dto.setId(id);
        dto.setTitle("Sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);

        return dto;
    }
}
