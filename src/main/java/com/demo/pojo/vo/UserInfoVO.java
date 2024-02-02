package com.demo.pojo.vo;

import com.demo.pojo.entity.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * description 用户详情
 * @author 周建泽
 * @date 2024/1/30
 */
@Data
public class UserInfoVO {
    /**
     * id
     */
    private String id;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 手机号
     */
    private String phone;

    public UserInfoVO(User user){
        BeanUtils.copyProperties(user,this);
    }
}
