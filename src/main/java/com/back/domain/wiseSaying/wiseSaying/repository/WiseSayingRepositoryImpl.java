package com.back.domain.wiseSaying.wiseSaying.repository;

import com.back.domain.wiseSaying.wiseSaying.entity.QWiseSaying;
import com.back.domain.wiseSaying.wiseSaying.entity.WiseSaying;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class WiseSayingRepositoryImpl implements WiseSayingRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<WiseSaying> findQById(int id) {
        QWiseSaying wiseSaying = QWiseSaying.wiseSaying;

        return Optional.ofNullable(queryFactory
                .selectFrom(wiseSaying)
                .where(wiseSaying.id.eq(id))
                .fetchOne());
    }

    @Override
    public List<WiseSaying> findQAll() {
        QWiseSaying wiseSaying = QWiseSaying.wiseSaying;

        return queryFactory
                .selectFrom(wiseSaying)
                .fetch();
    }
}