package task.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.Services.PersonService;
import task.models.Person;
import task.models.Task;

import java.util.List;

@RequestMapping("/person")
@RestController
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping
    public List<Person> getAllPersons() {

        return service.getAllPersons();
    }

    @GetMapping("/{personalNumber}")
    public Person getPersonByPersonalNumber(@PathVariable int personalNumber) {
        return service.getPersonByPersonalNumber(personalNumber);
    }

    @PostMapping
    public void savePerson(@RequestBody Person newPerson)
    {
        service.save(newPerson);
    }

    @DeleteMapping("/{id}")
    public void deleltePerson(@PathVariable String id) {
        service.deletePerson(id);
    }

    @GetMapping("/task/{id}")
    public List<Task> getAllPersonTasks(@PathVariable String id) {
        return service.getAllPersonTasks(id);
    }
}
