package com.zhi.dao.jdbcImp;

import com.zhi.dao.UserDao;
import com.zhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by paul on 2015/7/1.
 */
@Repository("userDao")
public class UserDaoJdbcImp implements UserDao{
    JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource){
        System.out.println(dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int login(User user) {
        System.out.println(jdbcTemplate);
        Integer id;
        try {
             id = jdbcTemplate.queryForObject("select id from user_info where username = ? and password = ? ",
                    new Object[]{user.getUsername(),user.getPassword()},Integer.class);
                return id;
        }catch (IncorrectResultSizeDataAccessException exception){
            return -1;
        }
    }
    @Override
    public int register(User user) {
        int count = jdbcTemplate.queryForObject("select count(*) from user_info where username = ?",Integer.class,user.getUsername());
        System.out.println(count);
        if (count == 0){
            final String SQL = "insert into user_info(username,password) values(?,?)";
            final String USERNAME = user.getUsername();
            final String PASSWORD = user.getPassword();
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(SQL,new String[]{"id"});
                    ps.setString(1,USERNAME);
                    ps.setString(2,PASSWORD);
                    return ps;
                }
            },keyHolder);
            return keyHolder.getKey().byteValue();
        }
        return -1;
    }


}
