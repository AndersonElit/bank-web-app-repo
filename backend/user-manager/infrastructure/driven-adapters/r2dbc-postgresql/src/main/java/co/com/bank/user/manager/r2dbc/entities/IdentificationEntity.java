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
@Table("identification")
public class IdentificationEntity {
    @Id
    private Integer id;
    @Column("user_id")
    private Integer userId;
    @Column("identification_type_id")
    private Integer identificationTypeId;
    @Column("identification_number")
    private String identificationNumber;
}
