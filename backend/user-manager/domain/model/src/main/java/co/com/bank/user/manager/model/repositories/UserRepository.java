package co.com.bank.user.manager.model.repositories;

import co.com.bank.user.manager.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> saveUser(User user);
}
