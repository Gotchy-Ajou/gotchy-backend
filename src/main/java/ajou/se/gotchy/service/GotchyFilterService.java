package ajou.se.gotchy.service;

import ajou.se.gotchy.domain.dto.GotchyFilterDto;
import ajou.se.gotchy.domain.entity.Gotchy;
import ajou.se.gotchy.repository.GotchyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GotchyFilterService {
    private final GotchyRepository gotchyRepository;

    public List<GotchyFilterDto> findFilter() {
        List<GotchyFilterDto> filterResponseDtoList = new ArrayList<>();
        List<Gotchy> gotchyList = gotchyRepository.findAll();

        // todo: 선택한 필더에 해당하는 가치만 보이도록 수정

        for(Gotchy gotchy : gotchyList) {
            filterResponseDtoList.add(new GotchyFilterDto(gotchy));
        }
        return filterResponseDtoList;
    }
}
