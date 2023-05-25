package ajou.se.gotchy.controller;

import ajou.se.gotchy.domain.ResponseApiMessage;
import ajou.se.gotchy.domain.dto.UsersResponseDto;
import ajou.se.gotchy.domain.dto.UsersSaveRequestDto;
import ajou.se.gotchy.domain.dto.UsersUpdateRequestDto;
import ajou.se.gotchy.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UsersController extends BaseController {
    private static int SUCCESS_CODE = 200;

    private final UsersService usersService;

    @PostMapping("api/v1/users")
    public ResponseEntity<ResponseApiMessage> save(@RequestBody UsersSaveRequestDto requestDto){
        Long users_Id = usersService.save(requestDto);

        return sendResponseHttpByJson(SUCCESS_CODE, "User is saved.", users_Id);
    }

    @GetMapping("api/v1/users/{usersId}")
    public ResponseEntity<ResponseApiMessage> findById(@PathVariable Long usersId) {
        UsersResponseDto responseDto = usersService.findById(usersId);

        return sendResponseHttpByJson(SUCCESS_CODE, "User is loaded. USER_ID=" + usersId, responseDto);
    }

    @GetMapping("api/v1/users")
    public ResponseEntity<ResponseApiMessage> findAllUsers() {
        List<UsersResponseDto> responseDtoList = usersService.findAll();

        return sendResponseHttpByJson(SUCCESS_CODE, "All users are loaded", responseDtoList);
    }

    @PutMapping("api/v1/users/{usersId")
    public ResponseEntity<ResponseApiMessage> update(@PathVariable Long usersId, @RequestBody UsersUpdateRequestDto requestDto) {
        UsersResponseDto responseDto = usersService.update(usersId, requestDto);

        return sendResponseHttpByJson(SUCCESS_CODE, "User is updated. USER_ID=" + usersId, responseDto);
    }

    @DeleteMapping("api/v1/users/{usersId")
    public ResponseEntity<ResponseApiMessage> delete(@PathVariable Long usersId){
        Long users_id = usersService.delete(usersId);

        return sendResponseHttpByJson(SUCCESS_CODE, "User is deleted. USER_ID=" + usersId, users_id);
    }
}
