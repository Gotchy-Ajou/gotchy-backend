package ajou.se.gotchy.service;

import ajou.se.gotchy.domain.dto.PostsResponseDto;
import ajou.se.gotchy.domain.dto.PostsSaveRequestDto;
import ajou.se.gotchy.domain.dto.PostsUpdateReqeustDto;
import ajou.se.gotchy.domain.entity.Posts;
import ajou.se.gotchy.domain.entity.Users;
import ajou.se.gotchy.repository.PostsRepository;
import ajou.se.gotchy.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostsSerivce {
    private final PostsRepository postsRepository;
    private final UsersRepository usersRepository;

    private Posts findPosts(Long postsId) {
        return postsRepository.findById(postsId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. POST_ID=" + postsId));
    }

    public Users findUsers(Long userId) {
        return usersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. USER_ID=" + userId));
    }

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        Posts posts = requestDto.toEntity();

        return postsRepository.save(posts).getPostsId();
    }

    public PostsResponseDto findById(Long postsId) {
        Posts posts = findPosts(postsId);

        return new PostsResponseDto(posts);
    }

    public List<PostsResponseDto> findAll() {
        List<PostsResponseDto> postsResponseDtoList = new ArrayList<>();
        List<Posts> postsList = postsRepository.findAll();

        for(Posts posts : postsList){
            postsResponseDtoList.add(new PostsResponseDto(posts));
        }

        return postsResponseDtoList;
    }

    @Transactional
    public PostsResponseDto update(Long postsId, PostsUpdateReqeustDto reqeustDto) {
        Posts posts = findPosts(postsId);
        posts.update(reqeustDto.getTitle(), reqeustDto.getContent());

        return new PostsResponseDto(posts);
    }

    @Transactional
    public Long delete(Long postsId) {
        Posts posts = findPosts(postsId);
        postsRepository.delete(posts);
        return postsId;
    }
}
