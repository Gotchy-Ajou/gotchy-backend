package ajou.se.gotchy.controller;

import ajou.se.gotchy.domain.ResponseApiMessage;
import ajou.se.gotchy.domain.dto.HobbyResponseDto;
import ajou.se.gotchy.domain.dto.HobbySaveRequestDto;
import ajou.se.gotchy.domain.dto.HobbyUpdateRequestDto;
import ajou.se.gotchy.service.HobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HobbyController extends BaseController {
    private static int SUCCESS_CODE = 200;
    private final HobbyService hobbyService;

    @PostMapping("api/v1/hobby")
    public ResponseEntity<ResponseApiMessage> save(@RequestBody HobbySaveRequestDto requestDto) {
        Long hobby_id = hobbyService.save(requestDto);

        return sendResponseHttpByJson(SUCCESS_CODE, "Hobby is saved.", hobby_id);
    }

    @GetMapping("api/v1/hobby/{hobbyId}")
    public ResponseEntity<ResponseApiMessage> findById(@PathVariable Long hobbyId) {
        HobbyResponseDto responseDto = hobbyService.findById(hobbyId);

        return sendResponseHttpByJson(SUCCESS_CODE, "Hobby is loaded. HOBBY_ID=" + hobbyId, responseDto);
    }

    @GetMapping("api/v1/hobby")
    public ResponseEntity<ResponseApiMessage> findAll() {
        List<HobbyResponseDto> responseDtoList = hobbyService.findAll();

        return sendResponseHttpByJson(SUCCESS_CODE, "All hobbies are loaded.", responseDtoList);
    }

    @PutMapping("api/v1/hobby/{hobbyId}")
    public ResponseEntity<ResponseApiMessage> update(@PathVariable Long hobbyId, @RequestBody HobbyUpdateRequestDto requestDto) {
        HobbyResponseDto responseDto = hobbyService.update(hobbyId, requestDto);

        return sendResponseHttpByJson(SUCCESS_CODE, "Hobby is updated. HOBBY_ID=" + hobbyId, responseDto);
    }

    @DeleteMapping("api/v1/hobby/{hobbyId}")
    public ResponseEntity<ResponseApiMessage> delete(@PathVariable Long hobbyId) {
        Long hobby_id = hobbyService.delete(hobbyId);

        return sendResponseHttpByJson(SUCCESS_CODE, "Hobby is deleted. HOBBY_ID=" + hobbyId, hobby_id);
    }
}
