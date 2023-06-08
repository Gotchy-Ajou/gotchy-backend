package ajou.se.gotchy.service;

import ajou.se.gotchy.domain.dto.Users.UserWithGotchyResponseDto;
import ajou.se.gotchy.domain.dto.Users.UsersResponseDto;
import ajou.se.gotchy.domain.dto.Users.UsersSaveRequestDto;
import ajou.se.gotchy.domain.dto.Users.UsersUpdateRequestDto;
import ajou.se.gotchy.domain.entity.Gotchy;
import ajou.se.gotchy.domain.entity.Users;
import ajou.se.gotchy.repository.GotchyRepository;
import ajou.se.gotchy.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final GotchyRepository gotchyRepository;

    public Users findUsers(Long usersId) {
        return usersRepository.findById(usersId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. USER_ID=" + usersId));
    }

    @Transactional
    public Long save(UsersSaveRequestDto requestDto){
        Users users = requestDto.toEntity();

        return usersRepository.save(users).getUsersId();
    }

    public UsersResponseDto findById(Long usersId) {
        Users users = findUsers(usersId);

        return new UsersResponseDto(users);
    }

    public List<UsersResponseDto> findAll() {
        List<UsersResponseDto> usersResponseDtoList = new ArrayList<>();
        List<Users> usersList = usersRepository.findAll();

        for (Users users : usersList) {
            usersResponseDtoList.add(new UsersResponseDto(users));
        }

        return usersResponseDtoList;
    }

    @Transactional
    public UsersResponseDto update(Long usersId, UsersUpdateRequestDto requestDto) {
        Users users = findUsers(usersId);

        users.update(requestDto.getPassword(), requestDto.getPhotoUrl(), requestDto.getPhone(), requestDto.getRegion(), requestDto.getAccount());

        return findById(usersId);
    }

    @Transactional
    public Long delete(Long usersId) {
        Users users = findUsers(usersId);
        usersRepository.delete(users);

        return usersId;
    }

    @Transactional
    public void apply(Long usersId, Long gotchyId){
        Users users = findUsers(usersId);
        Gotchy gotchy = gotchyRepository.findById(gotchyId)
                        .orElseThrow(() -> new IllegalArgumentException("해당 가치가 없습니다. GOTCHY_ID=" + gotchyId));
        users.addGotchy(gotchy);
        gotchy.addUsers(users);
    }

    public List<UserWithGotchyResponseDto> findMyApply(Long usersId) {
        List<UserWithGotchyResponseDto> userWithGotchyResponseDtoList = new ArrayList<>();
        Users users = findUsers(usersId);
        List<Gotchy> gotchyList = users.getGotchyList();

        for (Gotchy gotchy : gotchyList) {
            userWithGotchyResponseDtoList.add(new UserWithGotchyResponseDto(users, gotchy));
        }

        return userWithGotchyResponseDtoList;
    }

}
