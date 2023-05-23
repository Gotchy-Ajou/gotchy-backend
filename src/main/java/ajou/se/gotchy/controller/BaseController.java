package ajou.se.gotchy.controller;

import ajou.se.gotchy.domain.ResponseApiMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.nio.charset.StandardCharsets;

@Controller
class BaseController {

    public ResponseEntity<ResponseApiMessage> sendResponseHttpByJson(int httpStatus, String message, Object responseDate) {
        ResponseApiMessage responseApiMessage = ResponseApiMessage.builder()
                .httpStatus(httpStatus)
                .message(message)
                .responseDate(responseDate)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        return new ResponseEntity<>(responseApiMessage, headers, 200);
    }
}
