package ajou.se.gotchy.service;

import ajou.se.gotchy.domain.dto.HobbyResponseDto;
import ajou.se.gotchy.domain.dto.HobbySaveRequestDto;
import ajou.se.gotchy.domain.dto.HobbyUpdateRequestDto;
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
    public Long save(HobbySaveRequestDto requestDto){
        Hobby hobby = requestDto.toEntity();

        return hobbyRepository.save(hobby).getHobbyId();
    }

    public HobbyResponseDto findById(Long hobbyId){
        Hobby hobby = findHobby(hobbyId);

        return new HobbyResponseDto(hobby);
    }

    public List<HobbyResponseDto> findAll() {
        List<HobbyResponseDto> hobbyResponseDtoList = new ArrayList<>();
        List<Hobby> hobbyList = hobbyRepository.findAll();

        for(Hobby hobby : hobbyList){
            hobbyResponseDtoList.add(new HobbyResponseDto(hobby));
        }

        return hobbyResponseDtoList;
    }

    @Transactional
    public HobbyResponseDto update(Long hobbyId, HobbyUpdateRequestDto requestDto){
        Hobby hobby = findHobby(hobbyId);
        hobby.update(requestDto.getHobbyLevel());

        return new HobbyResponseDto(hobby);
    }

    @Transactional
    public Long delete(Long hobbyId){
        Hobby hobby = findHobby(hobbyId);
        hobbyRepository.delete(hobby);

        return hobbyId;
    }
}
