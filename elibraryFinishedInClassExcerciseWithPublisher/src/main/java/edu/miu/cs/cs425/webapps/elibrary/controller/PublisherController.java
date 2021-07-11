package edu.miu.cs.cs425.webapps.elibrary.controller;

import edu.miu.cs.cs425.webapps.elibrary.model.Book;
import edu.miu.cs.cs425.webapps.elibrary.model.Publisher;
import edu.miu.cs.cs425.webapps.elibrary.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping(value = {"/publisher/list"})
    public ModelAndView listPublishers() {
        var modelAndView = new ModelAndView();
        List<Publisher> publisher = publisherService.getPublisher();
        modelAndView.addObject("publisher", publisher);
        modelAndView.setViewName("publisher/list");
        return modelAndView;
    }
    @GetMapping(value = {"/publisher/new"})
    public String displayNewPublisherForm(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publisher/new";
    }

    @PostMapping(value = {"/publisher/new"})
    public String addNewBook(@Valid
                             @ModelAttribute("publisher") Publisher publisher,
                             BindingResult bindingResult,
                             Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "publisher/new";
        }
        publisher = publisherService.savePublisher(publisher);
        return "redirect:/publisher/list";
    }



}
