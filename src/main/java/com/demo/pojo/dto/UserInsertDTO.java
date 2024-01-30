package com.demo.pojo.dto;

import com.demo.pojo.entity.User;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

/**
 * description 新增用户DTO
 * @author 周建泽
 * @date 2024/1/18
 */
@Data
@Valid
public class UserInsertDTO {
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
        user.setUserName(userName);
        user.setPassword(password);
        user.setPhone(phone);
        user.setId(UUID.randomUUID().toString());
        return user;
    }
}
