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
@Table("demography")
public class DemographyEntity {
    @Id
    private Integer id;
    @Column("user_id")
    private Integer userId;
    @Column("occupation_id")
    private Integer occupationId;
    @Column("gender_id")
    private Integer genderId;
    @Column("country_id")
    private Integer countryId;
    @Column("marital_status_id")
    private Integer maritalStatusId;
}
