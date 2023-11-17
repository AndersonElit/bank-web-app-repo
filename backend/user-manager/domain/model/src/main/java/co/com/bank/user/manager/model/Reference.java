package co.com.bank.user.manager.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reference {
    private Integer id;
    private Integer userId;
    private Integer referenceTypeId;
    private String referenceName;
    private String contact;
}
