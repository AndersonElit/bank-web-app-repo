package co.com.bank.user.manager.r2dbc.repositories;

import co.com.bank.user.manager.r2dbc.entities.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PgsUserRepository extends ReactiveCrudRepository<UserEntity, Integer> {
}
