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
@Table("reference")
public class ReferenceEntity {
    @Id
    private Integer id;
    @Column("user_id")
    private Integer userId;
    @Column("reference_type_id")
    private Integer referenceTypeId;
    @Column("reference_name")
    private String referenceName;
    private String contact;
}
