package com.github.landyking.testcontainer;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table("t_user")
public class UserEntity {
    @Id
    Long id;
    String name;
    String description;
    Date createTime;
}