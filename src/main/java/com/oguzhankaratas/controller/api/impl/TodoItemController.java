package com.oguzhankaratas.controller.api.impl;


import com.oguzhankaratas.assist.FrontEnd;
import com.oguzhankaratas.business.dto.CreateTodoItemRequest;
import com.oguzhankaratas.business.dto.TodoDto;
import com.oguzhankaratas.business.services.TodoService;
import com.oguzhankaratas.controller.api.TodoItemApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Log4j2

//API
@RestController
@CrossOrigin(origins = FrontEnd.REACT_URL)
@RequestMapping("/api/todo/v1")
public class TodoItemController implements TodoItemApi {

    private final TodoService todoService;


    @Override
    @PostMapping("/create/")
    public ResponseEntity<?> apiCreate(@Valid @RequestBody CreateTodoItemRequest createTodoItemRequest) {
        return ResponseEntity.ok(todoService.create(createTodoItemRequest));
    }

    @Override
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<?> apiFindById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(200).body(todoService.todoItemFindById(id));
    }

    @Override
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> apiUpdate(@PathVariable(name = "id") Long id,@Valid TodoDto todoDto) {
        return ResponseEntity.ok().body(todoService.update(id,todoDto));
    }

    @Override
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> apiDelete(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(todoService.delete(id), HttpStatus.OK);
    }

    @Override
    @PutMapping("/done/{id}")
    public ResponseEntity<?> apiDone(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(todoService.done(id));
    }
}
