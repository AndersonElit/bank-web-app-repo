package co.com.bank.user.manager.model.repositories;

import co.com.bank.user.manager.model.Reference;
import reactor.core.publisher.Mono;

public interface ReferenceRepository {
    Mono<Reference> saveReference(Reference reference);
}
