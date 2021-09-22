package co.henry.web.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 2xx -> ok
// 4xx -> client
// 5xx -> server

@ResponseStatus(HttpStatus.NOT_FOUND) //예외처리 임의로 변경시킨다.
public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(String message) {
		super(message);
		
	}
}
