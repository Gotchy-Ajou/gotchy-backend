package ajou.se.gotchy.controller;

import ajou.se.gotchy.domain.ResponseApiMessage;
import ajou.se.gotchy.domain.dto.CateFilterDto;
import ajou.se.gotchy.service.FilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FilterController extends BaseController {
    private static int SUCCESS_CODE = 200;

    private final FilterService filterService;

    @GetMapping("api/v1/catefilter")
    public ResponseEntity<ResponseApiMessage> findAll() {
        List<CateFilterDto> responseDtoList = filterService.findAll();

        return sendResponseHttpByJson(SUCCESS_CODE, "Load the selected gotchy.", responseDtoList);
    }
}
