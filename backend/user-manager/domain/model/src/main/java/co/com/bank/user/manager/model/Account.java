package co.com.bank.user.manager.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private User user;
    private Reference reference;
}
