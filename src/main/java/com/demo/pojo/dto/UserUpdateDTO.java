package com.demo.pojo.dto;

import com.demo.pojo.entity.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

/**
 * description 用户更新DTO
 * @author 周建泽
 * @date 2024/1/31
 */
@Data
@Valid
public class UserUpdateDTO {
    /**
     * 用户id
     */
    @NotBlank(message = "用户id不能为空")
    private String id;
    /**
     * 用户名
     */
    @NotBlank(message = "用户名称不能为空")
    @Max(value = 45, message = "用户名称长度不能超过45个字符")
    private String userName;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Max(value = 15, message = "密码长度不能超过45个字符")
    private String password;
    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    @Max(value = 15, message = "手机号长度不能超过15个字符")
    private String phone;

    public User translate2Entity() {
        User user = new User();
        user.setId(this.id);
        BeanUtils.copyProperties(this, user);
        return user;
    }
}
