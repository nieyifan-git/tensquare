package com.tensquare.user.dao;

import com.tensquare.user.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nieyifan
 * @createTime 2019/12/26 14:27
 */
public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String userName);
}
