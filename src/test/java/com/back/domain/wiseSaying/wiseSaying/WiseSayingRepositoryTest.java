package com.back.domain.wiseSaying.wiseSaying;

import com.back.domain.member.member.entity.Member;
import com.back.domain.member.member.repository.MemberRepository;
import com.back.domain.wiseSaying.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.wiseSaying.repository.WiseSayingRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
class WiseSayingRepositoryTest {
    @Autowired
    private WiseSayingRepository wiseSayingRepository;

    @Test
    @DisplayName("findQById")
    void t1() {
        Optional<WiseSaying> wiseSayingOptional = wiseSayingRepository.findQById(1);

        assertThat(wiseSayingOptional).isPresent();
        WiseSaying wiseSaying = wiseSayingOptional.get();
        assertThat(wiseSaying.getId()).isEqualTo(1);
        assertThat(wiseSaying.getContent()).isEqualTo("명언 1");
        assertThat(wiseSaying.getAuthor()).isEqualTo("작가 1");
    }

    @Test
    @DisplayName("findQAll")
    void t2() {
        List<WiseSaying> wiseSayings = wiseSayingRepository.findQAll();

        assertThat(wiseSayings).hasSize(5);
        assertThat(wiseSayings.get(0).getContent()).isEqualTo("명언 1");
        assertThat(wiseSayings.get(0).getAuthor()).isEqualTo("작가 1");
    }

    @Test
    @DisplayName("qCount")
    void t3() {
        long count = wiseSayingRepository.qCount();

        assertThat(count).isEqualTo(5L);
    }
}