package co.com.bank.user.manager.r2dbc.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("contact")
public class ContactEntity {
    @Id
    private Integer id;
    @Column("user_id")
    private Integer userId;
    private String email;
    private String phone;
    private String address;
}
