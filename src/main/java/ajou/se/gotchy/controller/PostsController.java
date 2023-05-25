package ajou.se.gotchy.controller;

import ajou.se.gotchy.domain.ResponseApiMessage;
import ajou.se.gotchy.domain.dto.PostsResponseDto;
import ajou.se.gotchy.domain.dto.PostsSaveRequestDto;
import ajou.se.gotchy.domain.dto.PostsUpdateReqeustDto;
import ajou.se.gotchy.service.PostsSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsController extends BaseController{
    private static int SUCCES_CODE = 200;

    private final PostsSerivce postsSerivce;

    @PostMapping("api/v1/posts")
    public ResponseEntity<ResponseApiMessage> save(@RequestBody PostsSaveRequestDto requestDto) {
        Long posts_id = postsSerivce.save(requestDto);

        return sendResponseHttpByJson(SUCCES_CODE, "Post is saved.", posts_id);
    }

    @GetMapping("api/v1/posts/{postsId}")
    public ResponseEntity<ResponseApiMessage> findById(@PathVariable Long postsId) {
        PostsResponseDto responseDto = postsSerivce.findById(postsId);

        return sendResponseHttpByJson(SUCCES_CODE, "Post is loaded. POST_ID=" + postsId, responseDto);
    }

    @GetMapping("api/v1/posts")
    public ResponseEntity<ResponseApiMessage> findAllPosts() {
        List<PostsResponseDto> responseDtoList = postsSerivce.findAll();

        return sendResponseHttpByJson(SUCCES_CODE, "All posts are loaded", responseDtoList);
    }

    @PutMapping("api/v1/posts/{postsId}")
    public ResponseEntity<ResponseApiMessage> update(@PathVariable Long postsId, @RequestBody PostsUpdateReqeustDto reqeustDto){
        PostsResponseDto responseDto = postsSerivce.update(postsId, reqeustDto);

        return sendResponseHttpByJson(SUCCES_CODE, "Post is updated. POST_ID=" + postsId, responseDto);
    }

    @DeleteMapping("api/v1/posts/{postsId}")
    public ResponseEntity<ResponseApiMessage> delete(@PathVariable Long postsId) {
        Long posts_id = postsSerivce.delete(postsId);

        return sendResponseHttpByJson(SUCCES_CODE, "Post is deleted. POST_ID=" + postsId, posts_id);
    }
}
