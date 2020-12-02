package task.Services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.models.Person;
import task.models.Task;
import task.repositorys.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    @Autowired
    TaskService taskService;

    public void save(Person person) {
        if (person.getId() == null){
            person.setId(new ObjectId().toString());
        }
        repository.save(person);
    }

    public List<Person> getAllPersons()
    {
        return repository.findAll();
    }

    public Person getPersonByPersonalNumber(int personalNumber) {
        return repository.findByPersonalNumber(personalNumber);
    }

    public void deletePerson(String id)
    {
        repository.deleteById(id);
    }

    public List<Task> getAllPersonTasks(String id) {
        List<Task> allTasks =  taskService.getAllTasks();
        return allTasks.stream().filter(task -> {
            return Arrays.stream(task.getPersons()).anyMatch(person-> person.getId().equals(id));
        }).collect(Collectors.toList());
    }
}
