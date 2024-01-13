package com.example.todo.service;

import com.example.todo.model.DTO.TodoDto;
import com.example.todo.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DateServiceTest {
    @InjectMocks
    private DateService dateService;

    @InjectMocks
    private TodoService todoService;

    @Mock
    private TodoRepository todoRepository;
    @Test
    void nonValidDateThrowsException() {
        //Given
        TodoDto todoDto = new TodoDto();
        todoDto.setTitle("tets");
//        todoDto.setDate("2010-01-01");
        todoDto.setDate("01-01-2010");

        //when


        //act

//        assertThrows(Exception.class, () -> dateService.validateAndCreateTodo(todoDto));
        assertThrows(NumberFormatException.class, () -> dateService.validateAndCreateTodo(todoDto));
//        assertThrows(NullPointerException.class, () -> dateService.validateAndCreateTodo(todoDto));
    }
    @Test
    void validDate() {
        //given
        TodoDto todoDto = new TodoDto();
        todoDto.setTitle("tets");
        todoDto.setDate("2010-10-10");
//        todoDto.setDate("01-01-2010");

        //when
//        when(todoService.createTodo(todoDto.getTitle(),new Date())).then()


        assertDoesNotThrow(() -> dateService.validateAndCreateTodo(todoDto),"Test if no exception is thrown");
    }

    @Test
    void sumExceptions() {
        assertDoesNotThrow(() -> dateService.sum(4,2)); // cislo je v rozmedzi 0-10
        assertThrows(RuntimeException.class, () -> dateService.sum(4,55)); // cislo by nemalo byt vyssie ako 10
        assertThrows(NullPointerException.class, () -> dateService.sum(0,2)); // ziadne s cisel by nemalo byt nula
        assertThrows(NumberFormatException.class, () -> dateService.sum(1,-2)); // cislo by nemalo byt zaporne
        assertThrows(NullPointerException.class, () -> dateService.sum(2,0));
        assertThrows(NullPointerException.class, () -> dateService.sum(0,0));
    }

    @Test
    void sumTets(){
        assertNotEquals(5,dateService.sum(3,2));

        // tieto dve metody su uplne to iste
        assertEquals(-5,dateService.sum(3,2));
        assertThat(dateService.sum(3,2)).isEqualTo(-5);
    }
}