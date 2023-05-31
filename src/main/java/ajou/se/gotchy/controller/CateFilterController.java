package ajou.se.gotchy.controller;

import ajou.se.gotchy.domain.ResponseApiMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FilterController extends BaseController {
    private static int SUCCESS_CODE = 200;

    @GetMapping("api/v1/catefilter")
    public ResponseEntity<ResponseApiMessage> findAll() {
        // todo:
        // responseDto 받아오기
        return sendResponseHttpByJson(SUCCESS_CODE, "Load the selected gotchy.");
    }
}
