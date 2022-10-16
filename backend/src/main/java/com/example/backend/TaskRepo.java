package com.example.backend;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepo {

    private List<Task> tasks = new ArrayList<>(List.of(
            new Task("to do laundry", "1", TaskStatus.DONE),
            new Task("to bring the car to the service", "2", TaskStatus.IN_PROGRESS),
            new Task("to finish my coding exercises", "3", TaskStatus.OPEN)
    ));

    public boolean addTask(Task task) {
        this.tasks.add(task);
        return true;
    }

    public List<Task> getAllTasks() {
        return this.tasks;
    }

    public List<Task> getTaskByOpenStatus() {
        return this.tasks.stream().filter(task -> task.getStatus() == TaskStatus.OPEN).toList();
    }

    public Task getTaskById(String id) {
        for (Task task : this.tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TaskRepo{");
        sb.append("tasks=").append(tasks);
        sb.append('}');
        return sb.toString();
    }
}
