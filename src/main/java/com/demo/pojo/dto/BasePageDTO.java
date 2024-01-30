package com.demo.pojo.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * description
 * @author 周建泽
 * @date 2024/1/29
 */
@Data
@Valid
public class BasePageDTO {
    /**
     * 当前页
     */
    @Size(min = 1, message = "当前页不能小于1")
    private Integer currentPage;
    /**
     * 每页显示的条数
     */
    @Size(message = "每页显示的条数不能小于1")
    private Integer pageSize;
}
