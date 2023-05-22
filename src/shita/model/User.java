package shita.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Document
public class User {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;


}
