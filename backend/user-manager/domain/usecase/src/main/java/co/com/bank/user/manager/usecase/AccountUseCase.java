package co.com.bank.user.manager.usecase;

import co.com.bank.user.manager.model.Account;
import co.com.bank.user.manager.model.Reference;
import co.com.bank.user.manager.model.User;
import co.com.bank.user.manager.usecase.utils.ChainOperator;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import java.util.List;

@RequiredArgsConstructor
public class AccountUseCase {

    private final WriteOperationsUseCase writeOperationsUseCase;

    public Mono<Account> createAccount(Account account) {
        return ChainOperator.chainOneToMany(
                        writeOperationsUseCase.saveUser(account.getUser()),
                        Mono::just,
                        writeOperationsUseCase.saveReference(account.getReference())
                )
                .collectList()
                .map(AccountUseCase::buildDto);
    }

    private static Account buildDto(List<?> list) {
        return Account.builder()
                .user((User) list.get(0))
                .reference((Reference) list.get(1))
                .build();
    }

}
