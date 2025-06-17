package com.dav.sem3hw.repository;

import com.dav.sem3hw.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    /**
     * DB connection object
     */
//    private final JdbcTemplate jdbc;
//    private final UserMapper userMapper;

    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * Получение списка пользователей
     * @return список пользователей
     */
//    public List<User> getUsers() {
//        String sql = "secect * from \"user\"";
//        return jdbc.query(sql, userMapper);
//    }

    /**
     * Add user in DB
     * @param user user object
     */
//    public void addUser(User user) {
//        String sql = "insert into \"user\" (name, age, email) values (?, ?, ?)";
//        jbbc.update(sql, user.getName(), user.getAge(), user.getEmail());
//    }
}
