package com.yolo.controller;

import com.yolo.model.Task;
import com.yolo.model.Uwaga;
import com.yolo.service.UwagaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.yolo.service.TaskService;
import com.yolo.utils.Status;

import java.time.LocalDateTime;

@Controller
@ComponentScan
public class TodoController {

    private static final Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TaskService taskService;

    @Autowired
    private GlobalController globalController;

    @Autowired
    private UwagaService uwagaService;

    @RequestMapping(value = {"/task/saveTask"}, method = RequestMethod.POST)
    public String saveTodo(@ModelAttribute("reqTask") Task reqTask, final RedirectAttributes redirectAttributes) {
        logger.info("/task/save");
        try {
            reqTask.setCreateDate(LocalDateTime.now());
            reqTask.setStatus(Status.ACTIVE.getValue());
            reqTask.setUserId(globalController.getLoginUser().getId());
            taskService.save(reqTask);
            redirectAttributes.addFlashAttribute("msg", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msg", "fail");
            logger.error("save: " + e.getMessage());
        }
        return "redirect:/home";
    }

    @RequestMapping(value = {"/task/editTask"}, method = RequestMethod.POST)
    public String editTodo(@ModelAttribute("editTask") Task editTask, Model model) {
        logger.info("/task/editTask");
        try {
            Task task = taskService.findById(editTask.getId());
            if (!task.equals(editTask)) {
                taskService.update(editTask);
                model.addAttribute("msg", "success");
            } else {
                model.addAttribute("msg", "same");
            }
        } catch (Exception e) {
            model.addAttribute("msg", "fail");
            logger.error("editTask: " + e.getMessage());
        }
        model.addAttribute("editTodo", editTask);
        return "edit";
    }

    @RequestMapping(value = "/task/{operation}/{id}", method = RequestMethod.GET)
    public String todoOperation(@PathVariable("operation") String operation, @PathVariable("id") int id, final RedirectAttributes redirectAttributes, Model model) {

        logger.info("operacja ", operation);
        if (operation.equals("trash")) {
            Task task = taskService.findById(id);
            if (task != null) {
                task.setStatus(Status.PASSIVE.getValue());
                taskService.update(task);
                redirectAttributes.addFlashAttribute("msg", "trash");
            } else {
                redirectAttributes.addFlashAttribute("msg", "notfound");
            }
        }
        if (operation.equals("restore")) {
            Task task = taskService.findById(id);
            if (task != null) {
                task.setStatus(Status.ACTIVE.getValue());
                taskService.update(task);
                redirectAttributes.addFlashAttribute("msg", "active");
                redirectAttributes.addFlashAttribute("msgText", "Task " + task.getTaskName() + " Restored Successfully.");
            } else {
                redirectAttributes.addFlashAttribute("msg", "active_fail");
                redirectAttributes.addFlashAttribute("msgText", "Task Activation fail:" + task.getTaskName());
            }
        } else if (operation.equals("delete")) {
            if (taskService.delete(id)) {
                redirectAttributes.addFlashAttribute("msg", "del");
                redirectAttributes.addFlashAttribute("msgText", " Task deleted"); // usuniety w calosci
            } else {
                logger.info("jakis blad  usuwania");
                // blad usuwania?
            }
        } else if (operation.equals("edit")) {
            Task editTask = taskService.findById(id);
            if (editTask != null) {
                model.addAttribute("editTask", editTask);
                return "edit";
            } else {
                redirectAttributes.addFlashAttribute("msg", "notfound");
            }
        }
        return "redirect:/home";
    }

//    Uwagi
    /*

    @RequestMapping(value = {"/task/saveTask"}, method = RequestMethod.POST)
    public String saveTodo(@ModelAttribute("reqTask") Task reqTask, final RedirectAttributes redirectAttributes) {
        logger.info("/task/save");
        try {
            reqTask.setCreateDate(LocalDateTime.now());
            reqTask.setStatus(Status.ACTIVE.getValue());
            reqTask.setUserId(globalController.getLoginUser().getId());
            taskService.save(reqTask);
            redirectAttributes.addFlashAttribute("msg", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msg", "fail");
            logger.error("save: " + e.getMessage());
        }
        return "redirect:/home";
    }

     */

    @RequestMapping(value = {"uwagi/saveUwaga"})
    public String saveUwaga(@ModelAttribute("saveUwaga") Uwaga saveUwaga, final RedirectAttributes redirectAttributes) {
        try {
            saveUwaga.setCreateDate(LocalDateTime.now());
            saveUwaga.setUserId(globalController.getLoginUser().getId());
            saveUwaga.setRate(Uwaga.Rate.POSSITIVE);
            uwagaService.save(saveUwaga);
            redirectAttributes.addFlashAttribute("msg", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msg", "fail");
            logger.error("save: " + e.getMessage());
        }
        return "redirect:/home";
    }




}
