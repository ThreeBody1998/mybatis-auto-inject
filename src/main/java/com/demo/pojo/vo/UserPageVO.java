package com.demo.pojo.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.pojo.custom.PageConverter;
import com.demo.pojo.entity.User;
import com.demo.service.baseInterface.PageInterface;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * description 用户分页VO
 * @author 周建泽
 * @date 2024/1/29
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class UserPageVO extends PageConverter<User, UserPageVO> {
    /**
     * 用户id
     */
    private String Id;
    /**
     * 姓名
     */
    private String userName;
    /**
     * 手机号码
     */
    private String phone;

    @Override
    public UserPageVO convertToVO(User entity) {
        UserPageVO userPageVO = new UserPageVO();
        userPageVO.setId(entity.getId());
        userPageVO.setUserName(entity.getUserName());
        userPageVO.setPhone(entity.getPhone());
        return userPageVO;
    }
}
