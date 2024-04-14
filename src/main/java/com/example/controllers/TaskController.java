package com.example.controllers;


import com.example.models.Task;
import com.example.models.TaskStatus;
import com.example.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private  final TaskService taskService;

    /**
     * Посмотеть все задачи
     * @return список всех задач
     * */
    @GetMapping
    public List<Task> getAllTask(){
        return taskService.getALLTasks();
    }

    /**
     * Добавить задачу
     * @return Task
     * */
    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

     /**
     * Найти задачу по статусу
     *  @return список задач
     * */
    @GetMapping("/status/{status}")
    public List<Task> findTaskByStatus(@PathVariable TaskStatus status){
        return taskService.findTackByStatus(status);
    }

    /**
     * Изменить задачу
     * @return Task
     * */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable long id, @RequestBody Task task){
        return taskService.changeTask(id, task);
    }

    /**
     * Удалить задачу по ID
     * @return Task
     * */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id){
        taskService.deleteTask(id);
    }
}
