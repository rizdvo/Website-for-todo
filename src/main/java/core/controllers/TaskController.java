package core.controllers;

import core.domains.Task;
import core.dto.TaskDto;
import core.services.TaskService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Objects.isNull;

@Data
@Controller
@RequestMapping("/")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String tasks(Model model,
                        @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                        @RequestParam(value = "limit", required = false, defaultValue = "3") int limit) {

        List<Task> tasks = taskService.getAll((page - 1) * limit, limit);

        model.addAttribute("tasks", tasks);

        model.addAttribute("current_page", page);

        int totalPages = (int) Math.ceil(1.0 * taskService.getAllCount() / limit);

        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().toList();
            model.addAttribute("page_numbers", pageNumbers);
        }

        return "index";
    }

    @PostMapping("/{id}")
    public String edit(Model model,
                     @PathVariable Integer id,
                     @RequestBody TaskDto taskDto) {

        if (isNull(id) || id <= 0) {
            throw new RuntimeException("Invalid id");
        }

        Task task = taskService.edit(id, taskDto.getDescription(), taskDto.getStatus());
        return tasks(model,1, 10);
    }

    @PostMapping("/")
    public String add(Model model,
                      @RequestBody TaskDto taskDto) {

        Task task = taskService.create(taskDto.getDescription(), taskDto.getStatus());
        return tasks(model,1, 10);
    }

    @DeleteMapping("/{id}")
    public String delete(Model model,
                         @PathVariable Integer id) {

        if (isNull(id) || id <= 0) {
            throw new RuntimeException("Invalid id");
        }

        Task task = taskService.delete(id);

        return tasks(model,1, 10);
    }
}
