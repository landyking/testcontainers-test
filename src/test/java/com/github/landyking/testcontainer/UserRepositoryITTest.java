package com.github.landyking.testcontainer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class UserRepositoryITTest {
    @Resource
    UserRepository repository;

    @Test
    void testQuery() {
        final String prefix = UUID.randomUUID().toString();
        this.createUniqueUser(prefix);
        final List<UserEntity> hello = repository.queryByNamePrefix(prefix);
        Assertions.assertThat(hello.size()).isEqualTo(1);
    }

    private void createUniqueUser(String prefix) {
        final UserEntity entity = new UserEntity();
        entity.name = prefix + "_user";
        entity.description = "test";
        entity.createTime = new Date();
        repository.save(entity);
    }
}