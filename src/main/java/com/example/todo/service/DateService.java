package com.example.todo.service;

import com.example.todo.model.DTO.TodoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
public class DateService {
    private final TodoService todoService;

    public ResponseEntity<String> validateAndCreateTodo(TodoDto todoDto) {
        String dateString = todoDto.getDate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                                            // 2010-01-01
                                                            // 01-01-2010

        try {
            Date date = format.parse(dateString);
            String parsedDateString = format.format(date);
            if (dateString.equals(parsedDateString)) {
                log.info("The string has the format yyyy-MM-dd");
                todoService.createTodo(todoDto.getTitle(),todoService.convertStringToDate(todoDto.getDate()));
                return new ResponseEntity<>("Todo created", HttpStatus.CREATED);
            } else {
                log.error(todoDto.getDate());
                log.error("The string does not have the format yyyy-MM-dd");
            }
        } catch (Exception e) {
            log.error(todoDto.getDate());
            log.error("The string does not have the format yyyy-MM-dd");
            log.error(e.toString());
            throw new NumberFormatException("zly format");
        }

        return new ResponseEntity<>("The string does not have the format yyyy-MM-dd",HttpStatus.BAD_REQUEST);
    }

    public Integer sum(Integer a, Integer b){
        if (a+b < 0){
            throw new NumberFormatException("nemoze byt zaporne");
        }else if (a+b > 10){
            throw new RuntimeException("To uz je moc velke");
        }else if (a == 0 ||
                  b == 0){
            throw new NullPointerException("Zadaj obe cisla");
        }
        return (a+b) * -1;
    }

}
