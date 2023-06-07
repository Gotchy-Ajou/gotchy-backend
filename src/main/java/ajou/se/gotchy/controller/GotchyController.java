package ajou.se.gotchy.controller;

import ajou.se.gotchy.domain.ResponseApiMessage;
import ajou.se.gotchy.domain.dto.Gotchy.GotchyResponseDto;
import ajou.se.gotchy.domain.dto.Gotchy.GotchySaveRequestDto;
import ajou.se.gotchy.domain.dto.Gotchy.GotchyUpdateRequestDto;
import ajou.se.gotchy.service.GotchyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;



@RequiredArgsConstructor
@RestController
public class GotchyController extends BaseController {
    private final static int SUCCESS_CODE = 200;

    private final GotchyService gotchyService;

    @PostMapping("api/v1/gotchy")
    public ResponseEntity<ResponseApiMessage> save(@RequestBody GotchySaveRequestDto requestDto) {
        Long gotchy_id = gotchyService.save(requestDto);

        return sendResponseHttpByJson(SUCCESS_CODE, "Gotchy is saved.", gotchy_id);
    }

    @GetMapping("api/v1/gotchy/{gotchyId}")
    public ResponseEntity<ResponseApiMessage> findById(@PathVariable Long gotchyId) {
        GotchyResponseDto responseDto = gotchyService.findById(gotchyId);

        return sendResponseHttpByJson(SUCCESS_CODE, "Gotchy is loaded. GOTCHY_ID=" + gotchyId, responseDto);
    }

    @GetMapping("api/v1/gotchy")
    public ResponseEntity<ResponseApiMessage> findAll() {
        List<GotchyResponseDto> responseDtoList = gotchyService.findAll();

        return sendResponseHttpByJson(SUCCESS_CODE, "All gotchys are loaded.", responseDtoList);
    }

    @PostMapping("api/v1/gotchyfilter")
    public ResponseEntity<ResponseApiMessage> getFilter(@RequestBody GotchySaveRequestDto req) {
        List<GotchyResponseDto> responseDtoList = gotchyService.getFilter(req);

        return sendResponseHttpByJson(SUCCESS_CODE, "Selected gotchys are loaded.", responseDtoList);
    }

    @PutMapping("api/v1/gotchy/{gotchyId}")
    public ResponseEntity<ResponseApiMessage> update(@PathVariable Long gotchyId, @RequestBody GotchyUpdateRequestDto requestDto) {
        GotchyResponseDto responseDto = gotchyService.update(gotchyId, requestDto);

        return sendResponseHttpByJson(SUCCESS_CODE, "Gotchy is updated. GOTCHY_ID=" + gotchyId, responseDto);
    }

    @DeleteMapping("api/v1/gotchy/{gotchyId}")
    public ResponseEntity<ResponseApiMessage> delete(@PathVariable Long gotchyId) {
        Long gotchy_id = gotchyService.delete(gotchyId);

        return sendResponseHttpByJson(SUCCESS_CODE, "Gotchy is deleted. GOTCHY_ID=" + gotchyId, gotchy_id);
    }

    @GetMapping("api/v1/gotchy/date/{gotchyDate}")
    public ResponseEntity<ResponseApiMessage> findByDate(@PathVariable String gotchyDate) {
        List<GotchyResponseDto> responseDtoList = gotchyService.findByDate(gotchyDate);

        return sendResponseHttpByJson(SUCCESS_CODE, "All gotchys in Date=" + gotchyDate + "are loaded.", responseDtoList);
    }
}
