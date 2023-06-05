package ajou.se.gotchy.controller;

import ajou.se.gotchy.domain.ResponseApiMessage;
import ajou.se.gotchy.domain.dto.Users.*;
import ajou.se.gotchy.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UsersController extends BaseController {
    private final static int SUCCESS_CODE = 200;

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

    @PutMapping("api/v1/users/{usersId}")
    public ResponseEntity<ResponseApiMessage> update(@PathVariable Long usersId, @RequestBody UsersUpdateRequestDto requestDto) {
        UsersResponseDto responseDto = usersService.update(usersId, requestDto);

        return sendResponseHttpByJson(SUCCESS_CODE, "User is updated. USER_ID=" + usersId, responseDto);
    }

    @DeleteMapping("api/v1/users/{usersId}")
    public ResponseEntity<ResponseApiMessage> delete(@PathVariable Long usersId){
        Long users_id = usersService.delete(usersId);

        return sendResponseHttpByJson(SUCCESS_CODE, "User is deleted. USER_ID=" + usersId, users_id);
    }

    @PostMapping("api/v1/users/apply-gotchy")
    public ResponseEntity<ResponseApiMessage> apply(@RequestBody UsersApplyRequestDto requestDto) {
        Long users_id = requestDto.getUsersId();
        Long gotchy_id = requestDto.getGotchyId();
        usersService.apply(users_id, gotchy_id);

        return sendResponseHttpByJson(SUCCESS_CODE, "Gotchy has applied to User. GOTCHY_ID=" + gotchy_id + "USER_ID=" + users_id, requestDto);
    }

    @GetMapping("api/v1/users/{usersId}/my-apply")
    public ResponseEntity<ResponseApiMessage> findMyApply(@PathVariable Long usersId) {
        List<UserWithGotchyResponseDto> responseDtoList = usersService.findMyApply(usersId);

        return sendResponseHttpByJson(SUCCESS_CODE, "All applied gotchys are loaded. USER_ID=" + usersId, responseDtoList);
    }

    @GetMapping("api/v1/users/login")
    public String login() {
        return "login_form";
    }
}
