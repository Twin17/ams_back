package com.ams.repository;

import com.ams.domain.Aircraft;
import com.ams.dto.AircraftDto;
import com.ams.dto.PageDataDto;
import com.ams.dto.SearchDto;
import com.ams.mappers.AircraftDtoEntityMapper;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AircraftRepImpl implements AircraftRep {

    private final AircraftJpaPageRep jpaPageRep;

    private final AircraftJpaRep jpaRep;

    private final AircraftDtoEntityMapper dtoEntityMapper;

    @Value("${paging.default.pagenum}")
    private int defPageNum;

    @Value("${paging.default.pagesize}")
    private int defPageSize;

    @Value("${paging.default.maxpagesize}")
    private int maxPageSize;

    @Override
    public List<Aircraft> search(SearchDto request, PageDataDto pageData) {
        try {
            final int pageNum = Optional.ofNullable(request.getPageNum()).orElse(defPageNum);

            final int pageSize = Optional.ofNullable(request.getPageSize())
                    .map(size -> Math.min(size, maxPageSize))
                    .orElse(defPageSize);

            final PageRequest pagable = PageRequest.of(pageNum - 1, pageSize, Sort.by("id").descending());

            final Specification<Aircraft> spec = (root, cq, cb) -> {
                final List<Predicate> predicates = build(cb, root, request);
                return cb.and(predicates.toArray(new Predicate[0]));
            };

            final Page<Aircraft> page = jpaPageRep.findAll(spec, pagable);

            pageData.setTotal((int) page.getTotalElements());
            pageData.setPages(page.getTotalPages());
            pageData.setPegeNum(pageNum);
            pageData.setElements(page.getContent().size());
            pageData.setMaxPageSize(maxPageSize);

            return page.getContent();
        } catch (Exception e) {
            //Logger.getLogger("");
            //LOGGER
            throw(e);
        }
    }

    private List<Predicate> build(@NonNull CriteriaBuilder cb, @NotNull Root<Aircraft> root, @NonNull SearchDto request) {
        final List<Predicate> predicates = new ArrayList<>();

        if (request.getModel() != null) {
            predicates.add(cb.equal(root.get("model"), request.getModel()));
        }

        if (request.getManufacturer() != null) {
            predicates.add(cb.equal(root.get("manufacturer"), request.getManufacturer()));
        }

        return predicates;
    }

    @Override
    public Long add(AircraftDto aircraftDto) {

        final Aircraft aircraft = dtoEntityMapper.map(aircraftDto);

        final Aircraft savedAircraft = jpaRep.save(aircraft);

        return savedAircraft.getId();
    }

    @Override
    public Long update(AircraftDto aircraftDto) {

        final Aircraft aircraft = dtoEntityMapper.map(aircraftDto);

        final Aircraft savedAircraft = jpaRep.save(aircraft);

        return savedAircraft.getId();
    }

    @Override
    public void delete(AircraftDto aircraftDto) {
        jpaRep.deleteById(aircraftDto.getId());
    }

}
