package com.zhi.dao.jdbcImp;

import com.zhi.dao.UserDao;
import com.zhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Created by paul on 2015/7/1.
 */
@Repository
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
    public boolean register(User user) {
        return false;
    }

}
