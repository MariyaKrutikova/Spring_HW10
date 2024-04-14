package com.example.services;

import com.example.models.Task;
import com.example.models.TaskStatus;
import com.example.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private  final TaskRepository taskRepository;

    /**
     * Узнать все задачи
     * @return список задач
     * */
    public List<Task> getALLTasks(){
        return taskRepository.findAll();
    }

    /**
     * Узнать задачу по ID
     * @return Task
     * */
    public Optional<Task> getTaskById(long id){
        return taskRepository.findById(id);
    }

    /**
     * Изменить задачу
     * @return Task
     * */
    public Task changeTask(long id, Task newTask){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setDescription(newTask.getDescription());
            task.setStatus(newTask.getStatus());
            task.setCreationDate(newTask.getCreationDate());
            task.setCreationDate(newTask.getCreationDate());
            return taskRepository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    /**
     * Удалить задачу
     * @return Task
     * */
    public void deleteTask(long id){
        taskRepository.deleteById(id);
    }

    /**
     * Добавить задачу
     * @return Task
     * */
    public Task addTask(Task task){
        task.setCreationDate(LocalDateTime.now());
        return taskRepository.save(task);
    }

    /**
     * Найти задачу по статусу
     * @return список задач
     * */
    public List<Task> findTackByStatus(TaskStatus status){
        return taskRepository.findByStatus(status);
    }
}
