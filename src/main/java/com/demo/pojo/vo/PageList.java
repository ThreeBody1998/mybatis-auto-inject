package com.demo.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class PageList<T>{

    /**
     * 数据列表
     */
    private List<T> dataList;

    /**
     * 当前页码
     */
    private long currentPage;

    /**
     * 每页条数
     */
    private long limit;

    /**
     * 总数
     */
    private long total;

}
