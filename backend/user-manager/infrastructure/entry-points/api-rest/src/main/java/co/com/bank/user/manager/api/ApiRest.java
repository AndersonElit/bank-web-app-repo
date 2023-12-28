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

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ApiRest {

    private final AccountUseCase accountUseCase;

    @PostMapping(path = "/user/save")
    public Mono<ResponseEntity<GenericRes<Object>>> createAccount(@RequestBody Account account) {
        return accountUseCase
                .createAccount(account)
                .map(response -> ResponseEntity.status(HttpStatus.CREATED).body(
                        GenericRes.builder()
                                .body(response)
                                .statusCode(HttpStatus.CREATED.value())
                                .build()))
                .onErrorResume(error -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                        GenericRes.builder()
                                .body("Invalid user.")
                                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                .build())));
    }

}
