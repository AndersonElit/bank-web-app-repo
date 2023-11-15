package co.com.bank.user.manager.r2dbc.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("users")
public class UserEntity {
    @Id
    private Integer id;
    @Column("first_name")
    private String firstName;
    @Column("last_name")
    private String lastName;
    @Column("date_of_birth")
    private LocalDate dateOfBirth;
}
