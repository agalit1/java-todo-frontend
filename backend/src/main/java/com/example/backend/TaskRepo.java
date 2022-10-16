package com.example.backend;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TaskRepo {

    private Map<Integer, Task> tasks = new HashMap<>(Map.of(
            0, new Task("to do laundry", 0, TaskStatus.DONE),
            1, new Task("to bring the car to the service", 1, TaskStatus.IN_PROGRESS),
            2, new Task("to finish my coding exercises", 2, TaskStatus.OPEN)
    ));

    public boolean addTask(Task task) {
        int id = this.tasks.size();
        task.setId(id);
        this.tasks.put(id, task);
        return true;
    }

    public List<Task> getAllTasks() {
        return this.tasks.values().stream().toList();
    }

    public Task getTaskById(int id) {
        return this.tasks.get(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TaskRepo{");
        sb.append("tasks=").append(tasks);
        sb.append('}');
        return sb.toString();
    }

    public Task editTask(Task task) {
        return this.tasks.put(task.getId(), task);
    }

    public void deleteTask(int id) {
        this.tasks.remove(id);
    }
}
