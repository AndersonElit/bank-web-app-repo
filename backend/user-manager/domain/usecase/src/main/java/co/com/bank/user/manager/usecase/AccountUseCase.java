package co.com.bank.user.manager.usecase;

import co.com.bank.user.manager.model.Account;
import co.com.bank.user.manager.model.Reference;
import co.com.bank.user.manager.model.repositories.ReferenceRepository;
import co.com.bank.user.manager.model.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AccountUseCase {

    private final UserRepository userRepository;
    private final ReferenceRepository referenceRepository;

    public Mono<Account> createAccount(Account account) {
        Account accountResponse = Account.builder().build();
        return userRepository.saveUser(account.getUser())
                .flatMap(user -> {
                    accountResponse.setUser(user);
                    Reference reference = account.getReference();
                    reference.setUserId(user.getId());
                    return referenceRepository.saveReference(reference)
                            .map(ref -> {
                                accountResponse.setReference(ref);
                                return accountResponse;
                            });
                });
    }

}
