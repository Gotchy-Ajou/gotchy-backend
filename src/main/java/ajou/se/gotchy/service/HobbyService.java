package ajou.se.gotchy.service;

import ajou.se.gotchy.domain.dto.Hobby.HobbyResponseDto;
import ajou.se.gotchy.domain.dto.Hobby.HobbySaveRequestDto;
import ajou.se.gotchy.domain.dto.Hobby.HobbyUpdateRequestDto;
import ajou.se.gotchy.domain.entity.Hobby;
import ajou.se.gotchy.domain.entity.Users;
import ajou.se.gotchy.repository.HobbyRepository;
import ajou.se.gotchy.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HobbyService {
    private final HobbyRepository hobbyRepository;
    private final UsersRepository usersRepository;

    public Hobby findHobby(Long hobbyId) {
        return hobbyRepository.findById(hobbyId)
                .orElseThrow(() -> new IllegalArgumentException("해당 취미가 없습니다. HOBBY_ID=" + hobbyId));
    }

    public Users findUsers(Long userId) {
        return usersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. USER_ID=" + userId));
    }

    @Transactional
    public Long save(Long usersId, HobbySaveRequestDto requestDto){
        Users users = findUsers(usersId);
        Hobby hobby = requestDto.toEntity();
        hobby.addUsers(users);

        return hobbyRepository.save(hobby).getHobbyId();
    }

    public List<HobbyResponseDto> findAll(Long usersId) {
        List<HobbyResponseDto> hobbyResponseDtoList = new ArrayList<>();
        Users users = findUsers(usersId);
        List<Hobby> hobbyList = users.getHobbyList();

        for(Hobby hobby : hobbyList){
            hobbyResponseDtoList.add(new HobbyResponseDto(users, hobby));
        }

        return hobbyResponseDtoList;
    }

    @Transactional
    public HobbyResponseDto update(Long usersId, Long hobbyId, HobbyUpdateRequestDto requestDto){
        Users users = findUsers(usersId);
        Hobby hobby = findHobby(hobbyId);
        hobby.update(requestDto.getHobbyLevel());

        return new HobbyResponseDto(users, hobby);
    }
}
