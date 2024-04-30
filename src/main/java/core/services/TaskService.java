package core.services;

import core.dao.TaskDao;
import core.domains.Status;
import core.domains.Task;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class TaskService {
    private final TaskDao taskDao;

    public TaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public List<Task> getAll() {
        return taskDao.getAll();
    }

    public List<Task> getAll(int offset, int limit) {
        return taskDao.getAll(offset, limit);
    }

    public int getAllCount() {
        return taskDao.getAllCount();
    }

    public Task edit(int id, String description, Status status) {
        Task task = taskDao.getById(id);

        if (isNull(task)) {
            throw new RuntimeException("Not found");
        }

        task.setDescription(description);
        task.setStatus(status);
        taskDao.saveOrUpdate(task);
        return task;
    }

    public Task create(String description, Status status) {
        Task task = new Task();
        task.setDescription(description);
        task.setStatus(status);
        taskDao.saveOrUpdate(task);
        return task;
    }

    public Task delete(int id) {
        Task task = taskDao.getById(id);

        if (isNull(task)) {
            throw new RuntimeException("Not found");
        }

        taskDao.delete(task);
        return task;
    }
}
