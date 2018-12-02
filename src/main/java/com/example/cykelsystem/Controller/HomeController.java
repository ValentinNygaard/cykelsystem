package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.Person;
import com.example.cykelsystem.Service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    IService personService;

    @GetMapping("/")
    public String home(Model model) {

        List<Person> persons = personService.fetchAll();

        model.addAttribute("persons", persons);

        return "home/index";
    }

    @GetMapping("/viewone/{id}")
    public String viewone(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personService.findPersonById(id));
        return "home/viewone";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Person person) {
        personService.addPerson(person);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        Boolean deleted = personService.deletePerson(id);
        if(deleted) {
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personService.findPersonById(id));
        return "home/update";
    }

    @PostMapping("/updatePerson")
    public String updatePerson(@ModelAttribute Person person) {
        personService.updatePerson(person.getId(), person);
        return "redirect:/";
    }
}
