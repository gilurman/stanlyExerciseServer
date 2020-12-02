package task.Services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.models.Task;
import task.models.TaskType;
import task.repositorys.TaskRepository;
import task.repositorys.TaskTypeRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskTypeRepository taskTypeRepository;

    public void saveNewTask(Task task) {
        if (task.getId() == null){
            task.setId(new ObjectId().toString());
        }

        taskRepository.save(task);
    }

    public void saveNewTaskType(TaskType taskType) {
        if (taskType.getId() == null){
            taskType.setId(new ObjectId().toString());
        }

        taskTypeRepository.save(taskType);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<TaskType> getAllTaskTypes() {
        return taskTypeRepository.findAll();
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    public void deleteTaskType(String id) {
        taskTypeRepository.deleteById(id);
    }

}
