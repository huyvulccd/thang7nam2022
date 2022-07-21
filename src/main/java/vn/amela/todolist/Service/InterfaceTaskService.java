package vn.amela.todolist.Service;

import org.springframework.http.ResponseEntity;
import vn.amela.todolist.Model.ResponseTask;
import vn.amela.todolist.Model.Task;

import java.util.List;

public interface InterfaceTaskService {
    public List<Task> getAllTasks();
    public List<Task> getListTasksByCondition(int status, String keyword);
    public Task postTask(Task task);
    public ResponseEntity<ResponseTask> updateTask(Task task);
    public ResponseEntity<ResponseTask> deleteTask(Task task);
}
