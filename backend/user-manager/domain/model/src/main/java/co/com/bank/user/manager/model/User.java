package co.com.bank.user.manager.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}
