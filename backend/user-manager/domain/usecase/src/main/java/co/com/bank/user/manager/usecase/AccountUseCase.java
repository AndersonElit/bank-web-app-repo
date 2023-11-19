package co.com.bank.user.manager.usecase;

import co.com.bank.user.manager.model.Account;
import co.com.bank.user.manager.model.Reference;
import co.com.bank.user.manager.model.User;
import co.com.bank.user.manager.model.repositories.ReferenceRepository;
import co.com.bank.user.manager.model.repositories.UserRepository;
import co.com.bank.user.manager.usecase.utils.ChainOperator;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class AccountUseCase {

    private final UserRepository userRepository;
    private final ReferenceRepository referenceRepository;

    public Mono<Account> createAccount(Account account) {

        Function<User, Mono<Reference>> saveReference = user -> {
            Reference reference = account.getReference();
            reference.setUserId(user.getId());
            return referenceRepository.saveReference(reference);
        };

        return ChainOperator.chainOneToMany(
                        userRepository.saveUser(account.getUser()),
                        Mono::just,
                        saveReference
                )
                .collectList()
                .map(list -> {
                    User user = (User) list.get(0);
                    Reference reference = (Reference) list.get(1);
                    return Account.builder()
                            .user(user)
                            .reference(reference)
                            .build();
                });
    }

}
