package co.com.bank.user.manager.r2dbc.adapters;

import co.com.bank.user.manager.model.Reference;
import co.com.bank.user.manager.model.repositories.ReferenceRepository;
import co.com.bank.user.manager.r2dbc.entities.ReferenceEntity;
import co.com.bank.user.manager.r2dbc.repositories.PgsReferenceRepository;
import io.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class PgsReferenceAdapter implements ReferenceRepository {

    private final PgsReferenceRepository pgsReferenceRepository;
    private static final Logger LOGGER = Logger.getLogger(PgsReferenceAdapter.class.getName());

    @Override
    public Mono<Reference> saveReference(Reference reference) {
        LOGGER.info(() -> "Execute method saveReference in PgsReferenceAdapter.");
        return pgsReferenceRepository.save(Mapper.map(reference, ReferenceEntity.class))
                .map(entity -> Mapper.map(entity, Reference.class));
    }
}
