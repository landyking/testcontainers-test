package com.github.landyking.testcontainer;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Query("select * from t_user where name like concat(:prefix,'%')")
    List<UserEntity> queryByNamePrefix(@Param("prefix") String prefix);
}