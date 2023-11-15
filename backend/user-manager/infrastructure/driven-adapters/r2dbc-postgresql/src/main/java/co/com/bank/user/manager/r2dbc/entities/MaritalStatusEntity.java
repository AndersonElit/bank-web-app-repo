package co.com.bank.user.manager.r2dbc.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("marital_status")
public class MaritalStatusEntity {
    @Id
    private Integer id;
    private String abbreviation;
    private String description;
}
