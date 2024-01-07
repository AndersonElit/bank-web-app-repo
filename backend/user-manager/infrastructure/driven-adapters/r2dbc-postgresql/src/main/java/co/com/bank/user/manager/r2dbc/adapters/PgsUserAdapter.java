package co.com.bank.user.manager.r2dbc.adapters;

import co.com.bank.user.manager.model.User;
import co.com.bank.user.manager.model.repositories.UserRepository;
import co.com.bank.user.manager.r2dbc.entities.UserEntity;
import co.com.bank.user.manager.r2dbc.repositories.PgsUserRepository;
import io.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class PgsUserAdapter implements UserRepository {

    private final PgsUserRepository pgsUserRepository;
    private static final Logger LOGGER = Logger.getLogger(PgsUserAdapter.class.getName());

    @Override
    public Mono<User> saveUser(User user) {
        LOGGER.info(() -> "Execute method saveUser in PgsUserAdapter.");
        return pgsUserRepository
                .save(Mapper.map(user, UserEntity.class))
                .map(entity -> Mapper.map(entity, User.class));
    }

}
