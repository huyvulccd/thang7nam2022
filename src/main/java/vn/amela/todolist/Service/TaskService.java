package vn.amela.todolist.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.amela.todolist.Model.ResponseTask;
import vn.amela.todolist.Model.Task;
import vn.amela.todolist.Repository.TaskRepository;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService implements InterfaceTaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getListTasksByCondition(int status, String keyword) {
        List<Task> listTasks = taskRepository.findAll();
        List<Task> result = new ArrayList<>();
        for(Task task : listTasks) {
            if (task.getStatus()==status && task.getTitle().toLowerCase().contains(keyword.toLowerCase())){
                result.add(task);
            }
        }
        return result;
    }
    public List<Task> findPaginated(int pageable){
        List<Task> listTasks = taskRepository.findAll();
        int length = listTasks.size();
        return listTasks.subList((pageable-1)*10, pageable*10>=length?length:pageable*10);
    }
    @Override
    public Task postTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public ResponseEntity<ResponseTask> updateTask(Task task) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseTask> deleteTask(Task task) {
        return null;
    }
}
