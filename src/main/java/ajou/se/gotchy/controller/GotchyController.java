package ajou.se.gotchy.controller;

import ajou.se.gotchy.domain.ResponseApiMessage;
import ajou.se.gotchy.domain.dto.GotchyFilterDto;
import ajou.se.gotchy.domain.dto.GotchyResponseDto;
import ajou.se.gotchy.domain.dto.GotchySaveRequestDto;
import ajou.se.gotchy.domain.dto.GotchyUpdateRequestDto;
import ajou.se.gotchy.service.GotchyService;
import ajou.se.gotchy.service.GotchyFilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RequiredArgsConstructor
@RestController
public class GotchyController extends BaseController {
    private static int SUCCESS_CODE = 200;

    private final GotchyService gotchyService;
    private final GotchyFilterService gotchyFilterService;

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

    @GetMapping("api/vi/gotchy")
    public ResponseEntity<ResponseApiMessage> findAll() {
        List<GotchyResponseDto> responseDtoList = gotchyService.findAll();

        return sendResponseHttpByJson(SUCCESS_CODE, "All gotchys are loaded.", responseDtoList);
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
    @GetMapping("api/vi/gotchy/filter")
    public ResponseEntity<ResponseApiMessage> findFilter() {
        List<GotchyFilterDto> responseDtoList = gotchyFilterService.findFilter();

        return sendResponseHttpByJson(SUCCESS_CODE, "Load the selected gotchy.", responseDtoList);
    }
}
