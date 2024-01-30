package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.pojo.dto.UserPageDTO;
import com.demo.pojo.entity.User;
import com.demo.service.UserService;
import com.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author zhoujianze
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-01-26 16:25:31
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public Page<User> page(UserPageDTO userPageDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (userPageDTO.getQueryName() != null) {
            queryWrapper.like("user_name", userPageDTO.getQueryName());
        }
        Page<User> page= new Page<>(userPageDTO.getCurrentPage(), userPageDTO.getPageSize());
        return this.page(page, queryWrapper);
    }
}




