package vn.amela.todolist.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.amela.todolist.Model.Task;
import vn.amela.todolist.Service.TaskService;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/list-tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("")
    public String getListTasks(
            Model model,
            @RequestParam("page") Optional<Integer> page){
        int currentPage = page.orElse(1);
        model.addAttribute("listTask",taskService.findPaginated(currentPage));
        List<Integer> count_page = new ArrayList<Integer>();
        for (int i = 0; i < taskService.getAllTasks().size(); i+=10){
            count_page.add(i/10+1);
        }


        model.addAttribute("countPage", count_page);
        return "index.html";
    }
}
