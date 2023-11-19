package co.com.bank.user.manager.usecase;

import co.com.bank.user.manager.model.Reference;
import co.com.bank.user.manager.model.User;
import co.com.bank.user.manager.model.repositories.ReferenceRepository;
import co.com.bank.user.manager.model.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class WriteOperationsUseCase {

    private final UserRepository userRepository;
    private final ReferenceRepository referenceRepository;

    public Mono<User> saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public Function<User, Mono<Reference>> saveReference(Reference reference) {
        return user -> {
            reference.setUserId(user.getId());
            return referenceRepository.saveReference(reference);
        };
    }

}
