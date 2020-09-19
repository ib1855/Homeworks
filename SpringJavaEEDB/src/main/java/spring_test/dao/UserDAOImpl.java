package spring_test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spring_test.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getUsers(){
        return jdbcTemplate.query(
                "SELECT id, name FROM users",
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        return new User(resultSet.getInt("id"), resultSet.getString("name"));
                    }
                }
        );
    }
}
