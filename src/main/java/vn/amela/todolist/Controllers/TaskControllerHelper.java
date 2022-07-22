package vn.amela.todolist.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.amela.todolist.Service.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class TaskControllerHelper {
    @Autowired
    private TaskService taskService;

    @GetMapping("")
    public String getListTasks(
            Model model) {
        model.addAttribute("listTask", taskService.findPaginated(1));
        List<Integer> count_page = new ArrayList<Integer>();
        for (int i = 0; i < taskService.getAllTasks().size(); i += 10) {
            count_page.add(i / 10 + 1);
        }

        model.addAttribute("countPage", count_page);
        return "index.html";
    }
}
