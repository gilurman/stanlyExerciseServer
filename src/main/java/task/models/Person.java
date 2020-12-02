package task.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Person {
    @Id private String id;
    private int personalNumber;
    private String gender;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String rank;
    private String typeOfService;
    private String city;
    private String department;
    private ReleaseType[] releases;
    private int points;
}
