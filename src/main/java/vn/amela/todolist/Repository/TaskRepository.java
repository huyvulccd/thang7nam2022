package vn.amela.todolist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.amela.todolist.Model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
}
