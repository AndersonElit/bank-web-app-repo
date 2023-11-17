package co.com.bank.user.manager.r2dbc.adapters;

import co.com.bank.user.manager.model.Reference;
import co.com.bank.user.manager.model.repositories.ReferenceRepository;
import co.com.bank.user.manager.r2dbc.entities.ReferenceEntity;
import co.com.bank.user.manager.r2dbc.repositories.PgsReferenceRepository;
import lombok.RequiredArgsConstructor;
import org.mapper.Mapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PgsReferenceAdapter implements ReferenceRepository {

    private final PgsReferenceRepository pgsReferenceRepository;

    @Override
    public Mono<Reference> saveReference(Reference reference) {
        return pgsReferenceRepository.save(Mapper.map(reference, ReferenceEntity.class))
                .map(entity -> Mapper.map(entity, Reference.class));
    }
}
