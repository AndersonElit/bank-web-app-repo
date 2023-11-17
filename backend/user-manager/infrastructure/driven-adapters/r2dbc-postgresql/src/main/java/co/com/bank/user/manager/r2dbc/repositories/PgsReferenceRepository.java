package co.com.bank.user.manager.r2dbc.repositories;

import co.com.bank.user.manager.r2dbc.entities.ReferenceEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PgsReferenceRepository extends ReactiveCrudRepository<ReferenceEntity, Integer> {
}
