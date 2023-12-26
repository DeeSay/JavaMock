package com.example.mockTest.Controller;

import com.example.mockTest.Model.RequestDTO;
import com.example.mockTest.Model.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Random;

@RestController
public class MainController {
    private Logger log = LoggerFactory.getLogger(MainController.class);
    ObjectMapper mapper = new ObjectMapper();
    public BigDecimal getRandomBalance(BigDecimal max) {
        Random random = new Random();
        return new BigDecimal(random.nextInt(max.intValue()));
    }

    @PostMapping(
            value = "info/postBalances",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Object postBalances (@RequestBody RequestDTO requestDTO) {
        try {
            String clientId = requestDTO.getClientId();
            char firstDigit = clientId.charAt(0);
            BigDecimal maxLimit;
            BigDecimal balance;
            String curr;


            if(firstDigit == '8') {
                maxLimit = new BigDecimal(2000);
                balance = getRandomBalance(maxLimit);
                curr = "US";
            } else if (firstDigit == '9') {
                maxLimit = new BigDecimal(1000);
                balance = getRandomBalance(maxLimit);
                curr = "EU";
            } else {
                maxLimit = new BigDecimal(50000);
                balance = new BigDecimal(0);
                curr = "";
            }

            ResponseDTO responseDTO = new ResponseDTO();

            responseDTO.setRqUID(requestDTO.getRqUID());
            responseDTO.setClientId(clientId);
            responseDTO.setAccount(requestDTO.getAccount());
            responseDTO.setCurrency(curr);
            responseDTO.setBalance(balance);
            responseDTO.setMaxLimit(maxLimit);

            log.error("===== RequestDTO =====" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestDTO));
            log.error("===== ResponseDTO =====" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseDTO));

            return  responseDTO;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
