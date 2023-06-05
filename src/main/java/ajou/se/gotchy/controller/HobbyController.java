package ajou.se.gotchy.controller;

import ajou.se.gotchy.domain.ResponseApiMessage;
import ajou.se.gotchy.domain.dto.Hobby.HobbyResponseDto;
import ajou.se.gotchy.domain.dto.Hobby.HobbySaveRequestDto;
import ajou.se.gotchy.domain.dto.Hobby.HobbyUpdateRequestDto;
import ajou.se.gotchy.domain.entity.Hobby;
import ajou.se.gotchy.service.HobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HobbyController extends BaseController {
    private final static int SUCCESS_CODE = 200;
    private final HobbyService hobbyService;

    @PostMapping("api/v1/hobby/{usersId}")
    public ResponseEntity<ResponseApiMessage> save(@PathVariable Long usersId, @RequestBody HobbySaveRequestDto requestDto) {
        Long savedHobbyId = hobbyService.save(usersId, requestDto);

        return sendResponseHttpByJson(SUCCESS_CODE, "Hobby has saved", savedHobbyId);
    }

    @GetMapping("api/v1/hobby/{usersId}")
    public ResponseEntity<ResponseApiMessage> findAll(@PathVariable Long usersId) {
        List<HobbyResponseDto> responseDtoList = hobbyService.findAll(usersId);

        return sendResponseHttpByJson(SUCCESS_CODE, "All hobbies are loaded.", responseDtoList);
    }

    @PutMapping("api/v1/hobby/{usersId}/{hobbyId}")
    public ResponseEntity<ResponseApiMessage> update(@PathVariable Long usersId, @PathVariable Long hobbyId, @RequestBody HobbyUpdateRequestDto requestDto) {
        HobbyResponseDto responseDto = hobbyService.update(usersId, hobbyId, requestDto);

        return sendResponseHttpByJson(SUCCESS_CODE, "Hobby is updated. HOBBY_ID=" + hobbyId, responseDto);
    }
}
