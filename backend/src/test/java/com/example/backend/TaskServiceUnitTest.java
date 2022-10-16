package com.example.backend;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TaskServiceUnitTest {

    @Test
    public void getTaskByID() {
        // Given
        TaskRepo taskRepo = mock(TaskRepo.class);
        TaskService taskService = new TaskService(taskRepo);

        // When
        int id = 1;
        when(taskRepo.getTaskById(id)).thenReturn(new Task("to do laundry", 1, TaskStatus.OPEN));
        Task actual = taskService.getTaskById(id);

        // Then
        assertEquals(new Task("to do laundry", 1, TaskStatus.OPEN), actual);
    }

    @Test
    public void getAllTasks() {
        // Given
        TaskRepo taskRepo = mock(TaskRepo.class);
        TaskService taskService = new TaskService(taskRepo);
        List<Task> taskList = new ArrayList<>(List.of(
                new Task("to do my homework", 0, TaskStatus.OPEN),
                new Task("to go shopping", 1, TaskStatus.IN_PROGRESS),
                new Task("to do laundry", 2, TaskStatus.DONE)
        ));

        // When
        when(taskRepo.getAllTasks()).thenReturn(taskList);
        List<Task> actual = taskService.getAllTasks();
        // Then
        assertEquals(taskList, actual);
    }

}
