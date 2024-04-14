package com.example;

import com.example.models.Task;
import com.example.models.TaskStatus;
import com.example.repositories.TaskRepository;
import com.example.services.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;


@ExtendWith(MockitoExtension.class)
class TaskServiceSimpleTests {
	@Mock
	public TaskRepository taskRepository;

	@InjectMocks
	public TaskService taskService;


	/**
	 * Тест для метода поиска задачи по Id
	 * */
	@Test
	public void findTackByIdTest() {
		Task task1 = new Task(1L, "job", TaskStatus.NOT_STARTED, LocalDateTime.now());
		Task task2 = new Task(2L, "study", TaskStatus.IN_PROGRESS, LocalDateTime.now());
		Task task3 = new Task(3L, "eat", TaskStatus.COMPLETED, LocalDateTime.now());

		Mockito.when(taskRepository.findById(task1.getId())).thenReturn(Optional.of(task1));

 		taskService.getTaskById(1L);
		verify(taskRepository).findById(1L);
	}
	/**
	 * Тест для метода поиска задачи по статусу
	 * */
	@Test
	public void findTackByStatusTest() {

		Task task1 = new Task(1L, "job", TaskStatus.NOT_STARTED, LocalDateTime.now());
		Task task2 = new Task(2L, "study", TaskStatus.IN_PROGRESS, LocalDateTime.now());
		Task task3 = new Task(3L, "eat", TaskStatus.COMPLETED, LocalDateTime.now());
		Task task4 = new Task(4L, "sleep", TaskStatus.COMPLETED, LocalDateTime.now());

		List<Task> comletedList = new ArrayList<Task>();
		comletedList.add(task3);
		comletedList.add(task4);

		Mockito.when(taskRepository.findByStatus(TaskStatus.COMPLETED)).thenReturn(comletedList);

		taskService.findTackByStatus(TaskStatus.COMPLETED);
		verify(taskRepository).findByStatus(TaskStatus.COMPLETED);
	}

	/**
	 * Тест для метода получения всех задач
	 * */
	@Test
	public void getALLTasksTest() {

		Task task1 = new Task(1L, "job", TaskStatus.NOT_STARTED, LocalDateTime.now());
		Task task2 = new Task(2L, "study", TaskStatus.IN_PROGRESS, LocalDateTime.now());
		Task task3 = new Task(3L, "eat", TaskStatus.COMPLETED, LocalDateTime.now());
		Task task4 = new Task(4L, "sleep", TaskStatus.COMPLETED, LocalDateTime.now());

		List<Task> taskList = new ArrayList<Task>();
		taskList.add(task3);
		taskList.add(task4);
		taskList.add(task1);
		taskList.add(task2);

		Mockito.when(taskRepository.findAll()).thenReturn(taskList);
		taskService.getALLTasks();
		verify(taskRepository).findAll();
	}

}
