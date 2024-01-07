package co.com.bank.user.manager.api;
import co.com.bank.user.manager.model.Account;
import co.com.bank.user.manager.model.response.GenericRes;
import co.com.bank.user.manager.usecase.AccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ApiRest {

    private final AccountUseCase accountUseCase;
    private static final Logger LOGGER = Logger.getLogger(ApiRest.class.getName());

    @PostMapping(path = "/user/save")
    public Mono<ResponseEntity<GenericRes<Object>>> createAccount(@RequestBody Account account) {
        LOGGER.info(() -> "Execute method createAccount in ApiRest.");
        return accountUseCase
                .createAccount(account)
                .map(response -> ResponseEntity.status(HttpStatus.CREATED).body(
                        GenericRes.builder()
                                .body(response)
                                .statusCode(HttpStatus.CREATED.value())
                                .build()))
                .onErrorResume(error -> Mono.error(new RuntimeException("Invalid user.", error)));
    }

}
