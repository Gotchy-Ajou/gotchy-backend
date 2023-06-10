package ajou.se.gotchy.controller;

import ajou.se.gotchy.domain.ResponseApiMessage;
import ajou.se.gotchy.domain.dto.Posts.PostsResponseDto;
import ajou.se.gotchy.domain.dto.Posts.PostsSaveRequestDto;
import ajou.se.gotchy.domain.dto.Posts.PostsUpdateRequestDto;
import ajou.se.gotchy.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsController extends BaseController{
    private final static int SUCCESS_CODE = 200;

    private final PostsService postsService;

    @PostMapping("api/v1/posts")
    public ResponseEntity<ResponseApiMessage> save(@RequestBody PostsSaveRequestDto requestDto) {
        Long posts_id = postsService.save(requestDto);

        return sendResponseHttpByJson(SUCCESS_CODE, "Post is saved.", posts_id);
    }

    @GetMapping("api/v1/posts/{postsId}")
    public ResponseEntity<ResponseApiMessage> findById(@PathVariable Long postsId) {
        PostsResponseDto responseDto = postsService.findById(postsId);

        return sendResponseHttpByJson(SUCCESS_CODE, "Post is loaded. POST_ID=" + postsId, responseDto);
    }

    @GetMapping("api/v1/posts")
    public ResponseEntity<ResponseApiMessage> findAllPosts() {
        List<PostsResponseDto> responseDtoList = postsService.findAll();

        return sendResponseHttpByJson(SUCCESS_CODE, "All posts are loaded", responseDtoList);
    }

    @PutMapping("api/v1/posts/{postsId}")
    public ResponseEntity<ResponseApiMessage> update(@PathVariable Long postsId, @RequestBody PostsUpdateRequestDto requestDto){
        PostsResponseDto responseDto = postsService.update(postsId, requestDto);

        return sendResponseHttpByJson(SUCCESS_CODE, "Post is updated. POST_ID=" + postsId, responseDto);
    }

    @DeleteMapping("api/v1/posts/{postsId}")
    public ResponseEntity<ResponseApiMessage> delete(@PathVariable Long postsId) {
        Long posts_id = postsService.delete(postsId);

        return sendResponseHttpByJson(SUCCESS_CODE, "Post is deleted. POST_ID=" + postsId, posts_id);
    }
}
