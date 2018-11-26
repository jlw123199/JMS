package com.xl.commentservice.dao;

import com.xl.commentservice.model.UserEntity;


public interface UserDao {


    /**
     * 创建对象
     *
     * @param user
     */
    void saveUser(UserEntity user);

    /**
     * 根据用户名查询对象
     *
     * @param userName
     * @return
     */
    UserEntity findUserByUserName(String userName);

    /**
     * 更新对象
     *
     * @param user
     */
    void updateUser(UserEntity user);

    /**
     * 删除对象
     *
     * @param id
     */
    void deleteUserById(Long id);
}