package task.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import task.models.Task;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {

}
