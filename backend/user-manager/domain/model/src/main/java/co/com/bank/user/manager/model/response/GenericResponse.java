package co.com.bank.user.manager.model.response;

import lombok.*;

@Getter
@Builder
public class GenericResponse<T> {
    private T body;
    private Integer statusCode;
}
