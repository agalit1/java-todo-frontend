package com.example.backend;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {

    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public void addTask(Task task) {
        taskRepo.addTask(task);
    }

    public List<Task> getAllTasks() {
        return taskRepo.getAllTasks();
    }

    public Task getTaskById(int id) {
        return taskRepo.getTaskById(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TaskService{");
        sb.append("taskRepo=").append(taskRepo);
        sb.append('}');
        return sb.toString();
    }

    public Task editTask(Task task) {
        return this.taskRepo.editTask(task);
    }

    public void deleteTask(int id) {
        this.taskRepo.deleteTask(id);
    }
}
