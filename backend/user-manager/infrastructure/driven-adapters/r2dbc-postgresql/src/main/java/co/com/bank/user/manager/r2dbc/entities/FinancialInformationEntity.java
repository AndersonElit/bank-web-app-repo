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
@Table("financial_information")
public class FinancialInformationEntity {
    @Id
    private Integer id;
    @Column("user_id")
    private Integer userId;
    @Column("bank_account_number")
    private String bankAccountNumber;
    private Double income;
}
