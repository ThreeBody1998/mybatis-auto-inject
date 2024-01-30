package com.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.pojo.dto.UserPageDTO;
import com.demo.pojo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author zhoujianze
* @description 针对表【user】的数据库操作Service
* @createDate 2024-01-26 16:25:31
*/
public interface UserService extends IService<User> {
    /**
     * 分页查询
     * @param userPageDTO   分页查询条件
     * @return  分页查询
     */
    Page<User> page(UserPageDTO userPageDTO);

}
