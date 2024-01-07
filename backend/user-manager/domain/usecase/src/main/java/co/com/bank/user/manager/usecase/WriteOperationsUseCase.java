package co.com.bank.user.manager.usecase;

import co.com.bank.user.manager.model.Reference;
import co.com.bank.user.manager.model.User;
import co.com.bank.user.manager.model.repositories.ReferenceRepository;
import co.com.bank.user.manager.model.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;
import java.util.logging.Logger;

@RequiredArgsConstructor
public class WriteOperationsUseCase {

    private final UserRepository userRepository;
    private final ReferenceRepository referenceRepository;
    private static final Logger LOGGER = Logger.getLogger(WriteOperationsUseCase.class.getName());

    public Mono<User> saveUser(User user) {
        LOGGER.info(() -> "Execute method saveUser in WriteOperationsUseCase.");
        return userRepository.saveUser(user);
    }

    public Function<User, Mono<Reference>> saveReference(Reference reference) {
        LOGGER.info(() -> "Execute method saveReference in WriteOperationsUseCase.");
        return user -> {
            reference.setUserId(user.getId());
            return referenceRepository.saveReference(reference);
        };
    }

}
