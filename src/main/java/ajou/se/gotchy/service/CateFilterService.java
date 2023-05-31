package ajou.se.gotchy.service;

import ajou.se.gotchy.domain.dto.CateFilterDto;
import ajou.se.gotchy.domain.entity.Gotchy;
import ajou.se.gotchy.repository.GotchyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CateFilterService {
    private final GotchyRepository gotchyRepository;

    public List<CateFilterDto> findAll() {
        List<CateFilterDto> filterResponseDtoList = new ArrayList<>();
        List<Gotchy> gotchyList = gotchyRepository.findAll();
        
        // todo: 선택한 필더에 해당하는 가치만 보이도록 수정

        for(Gotchy gotchy : gotchyList) {
            filterResponseDtoList.add(new CateFilterDto(gotchy));
        }

        return filterResponseDtoList;
    }
}
