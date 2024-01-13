package com.example.todo.service;

import com.example.todo.model.DTO.TodoDto;
import com.example.todo.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DateServiceTest {
    @InjectMocks
    private DateService dateService;

    @Mock
    private TodoRepository todoRepository;
    @Test
    void validateAndCreateTodo() {
        //Given
        TodoDto todoDto = new TodoDto();
        todoDto.setTitle("tets");
//        todoDto.setDate("2010-01-01");
//        todoDto.setDate("01-01-2010");

        //when


        //act
//        assertThat(dateService.validateAndCreateTodo(todoDto))
//        assertThrows(dateService.validateAndCreateTodo(todoDto));
//        Exception exception =

//        assertThrows(Exception.class, () -> dateService.validateAndCreateTodo(todoDto));
        assertThrows(NumberFormatException.class, () -> dateService.validateAndCreateTodo(todoDto));
//        assertThrows(NullPointerException.class, () -> dateService.validateAndCreateTodo(todoDto));


    }
}