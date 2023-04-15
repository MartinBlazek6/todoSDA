package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final  TodoRepository todoRepository;

    //create
    public void createTodo(String title, Date date){
        todoRepository.save(new Todo(title,date));
    }

    //read

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public List<Todo> getAllByStatus(boolean status){
        return todoRepository.findAllByIsDone(status);
    }


    //update
    public void changeStatus(Long id){
        Todo todo = todoRepository.findById(id).get();
        todo.setIsDone(!todo.getIsDone());
        todoRepository.saveAndFlush(todo);
    }


    //delete
    public void deletedTodo(Long id){
        todoRepository.deleteById(id);
    }

    public Date convertStringToDate(String date){
        String dateString = date;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = null;
        try {
            date2 = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date2;
    }


}
