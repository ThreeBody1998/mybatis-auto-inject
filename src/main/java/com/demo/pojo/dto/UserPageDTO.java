package com.demo.pojo.dto;

import lombok.Data;

/**
 * description 用户分页查询DTO
 * @author 周建泽
 * @date 2024/1/29
 */
@Data
public class UserPageDTO extends BasePageDTO {
    /**
     * 模糊查询的姓名
     */
    private String queryName;
}
