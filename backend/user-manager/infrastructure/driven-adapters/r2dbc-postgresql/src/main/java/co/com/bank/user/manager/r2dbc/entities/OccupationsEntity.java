package co.com.bank.user.manager.r2dbc.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("occupations")
public class OccupationsEntity {
    @Id
    private Integer id;
    private String abbreviation;
    private String description;
}
