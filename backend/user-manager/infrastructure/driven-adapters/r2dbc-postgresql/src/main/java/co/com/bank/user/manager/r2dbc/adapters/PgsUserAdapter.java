package co.com.bank.user.manager.r2dbc.adapters;

import co.com.bank.user.manager.model.User;
import co.com.bank.user.manager.model.repositories.UserRepository;
import co.com.bank.user.manager.r2dbc.entities.UserEntity;
import co.com.bank.user.manager.r2dbc.repositories.PgsUserRepository;
import lombok.RequiredArgsConstructor;
import org.mapper.Mapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PgsUserAdapter implements UserRepository {

    private final PgsUserRepository pgsUserRepository;

    @Override
    public Mono<User> saveUser(User user) {
        return pgsUserRepository
                .save(Mapper.map(user, UserEntity.class))
                .map(entity -> Mapper.map(entity, User.class));
    }

}
