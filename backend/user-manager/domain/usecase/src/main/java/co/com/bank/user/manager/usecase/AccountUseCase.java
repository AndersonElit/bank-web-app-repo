package co.com.bank.user.manager.usecase;

import co.com.bank.user.manager.model.Account;
import co.com.bank.user.manager.model.User;
import co.com.bank.user.manager.model.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AccountUseCase {

    private final UserRepository userRepository;

    public Mono<User> saveUser(Account account) {
        return userRepository.saveUser(account.getUser());
    }

}
