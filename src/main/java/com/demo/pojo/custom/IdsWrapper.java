package com.demo.pojo.custom;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

/**
 * description :对象接收ID
 * @author 周建泽
 * @date 2024/1/29
 */
@Valid
@Data
public class IdsWrapper {
    /**
     * ID列表
     */
    private List<String> ids;
}
