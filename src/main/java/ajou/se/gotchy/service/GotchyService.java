package ajou.se.gotchy.service;

import ajou.se.gotchy.domain.dto.Gotchy.GotchyResponseDto;
import ajou.se.gotchy.domain.dto.Gotchy.GotchySaveRequestDto;
import ajou.se.gotchy.domain.dto.Gotchy.GotchyUpdateRequestDto;
import ajou.se.gotchy.domain.entity.Gotchy;
import ajou.se.gotchy.repository.GotchyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GotchyService {
    private final GotchyRepository gotchyRepository;

    public Gotchy findGotchy(Long gotchyId) {
        return gotchyRepository.findById(gotchyId)
                .orElseThrow(() -> new IllegalArgumentException("해당 가치가 없습니다. GOTCHY_ID" + gotchyId));
    }
    @Transactional
    public Long save(GotchySaveRequestDto requestDto){
        Gotchy gotchy = requestDto.toEntity();

        return gotchyRepository.save(gotchy).getGotchyId();
    }

    public GotchyResponseDto findById(Long gotchyId) {
        Gotchy gotchy = findGotchy(gotchyId);

        return new GotchyResponseDto(gotchy);
    }

    public List<GotchyResponseDto> findAll() {
        List<GotchyResponseDto> gotchyResponseDtoList = new ArrayList<>();
        List<Gotchy> gotchyList = gotchyRepository.findAll();

        for(Gotchy gotchy : gotchyList) {
            gotchyResponseDtoList.add(new GotchyResponseDto(gotchy));
        }

        return gotchyResponseDtoList;
    }

    @Transactional
    public GotchyResponseDto update(Long gotchyId, GotchyUpdateRequestDto requestDto) {
        Gotchy gotchy = findGotchy(gotchyId);
        gotchy.update(requestDto.getGotchyName(), requestDto.getMode(), requestDto.getGotchyDate(), requestDto.getGotchyTime(), requestDto.getLocation(), requestDto.getGotchyPhotoUrl(), requestDto.getPrice(), requestDto.getHeadcount(), requestDto.getLevel(), requestDto.getGender(), requestDto.getUseTime());

        return new GotchyResponseDto(gotchy);
    }

    @Transactional
    public Long delete(Long gotchyId) {
        Gotchy gotchy = findGotchy(gotchyId);
        gotchyRepository.delete(gotchy);

        return gotchyId;
    }

    public List<GotchyResponseDto> findbyDate(LocalDate gotchyDate) {
        List<GotchyResponseDto> gotchyResponseDtoList = new ArrayList<>();
        List<Gotchy> gotchyList = gotchyRepository.findAll();

        for(Gotchy gotchy : gotchyList) {
            if(gotchy.getGotchyDate() == gotchyDate){
                gotchyResponseDtoList.add(new GotchyResponseDto(gotchy));
            }
        }

        return gotchyResponseDtoList;
    }
}
