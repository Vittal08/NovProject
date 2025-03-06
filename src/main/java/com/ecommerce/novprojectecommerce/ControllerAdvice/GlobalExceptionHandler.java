package com.ecommerce.novprojectecommerce.ControllerAdvice;
import com.ecommerce.novprojectecommerce.Exceptions.ProductNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundExeption.class)
    public ResponseEntity<String> handleProductNotFound(ProductNotFoundExeption productNotFoundExeption) {
        ResponseEntity<String> response = new ResponseEntity<>("Product NotFound Exception ",
                HttpStatus.BAD_REQUEST);
        return response ;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)

    public ResponseEntity<String> handleIndexOutOfBoundException(){
        ResponseEntity<String> response = new ResponseEntity<>("Index Out of Bound Error",HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handlesRuntimeException(RuntimeException runtimeException){
        ResponseEntity<String> response = new ResponseEntity<>("Runtime Exception ",
                HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }
}