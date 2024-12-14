package ru.mfti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


//REST API
@RestController
class SummatorController {
    
    @GetMapping("/make")
    public String arithmeticExpression(String expression) {
        return fun(expression);
    }
	
	//логику писать сюда
    public static String fun(String str){
        return String.valueOf(Summator.calculation(str));
    }


}
