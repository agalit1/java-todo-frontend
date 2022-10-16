package com.example.backend;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TaskUnitTest {

    @Test
    public void getTaskByIDWithMockito() {
        // Given
        TaskRepo taskRepo = mock(TaskRepo.class);
        TaskService taskService = new TaskService(taskRepo);

        // When
        String id = "1";
        when(taskRepo.getTaskById(id)).thenReturn(new Task("to do laundry", "1", TaskStatus.OPEN));
        Task actual = taskService.getTaskById(id);

        // Then
        assertEquals(new Task("to do laundry", "1", TaskStatus.OPEN), actual);
    }

    @Test
    public void getAllTasksWithMockito() {
        // Given
        TaskRepo taskRepo = mock(TaskRepo.class);
        TaskService taskService = new TaskService(taskRepo);
        List<Task> taskList = taskRepo.getAllTasks();

        // When
        when(taskRepo.getAllTasks()).thenReturn(taskList);
        List<Task> actual = taskService.getAllTasks();
        // Then
        assertEquals(taskList, actual);

    }
}
