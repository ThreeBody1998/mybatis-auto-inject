package com.demo.pojo.custom;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.pojo.vo.PageList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * description 分页通用抽象类
 *
 * @author 周建泽
 * @date 2024/1/29
 */
public abstract class PageConverter<T, V> {
    /**
     * 默认每页大小
     */
    private final static int DEFAULT_SIZE = 10;
    /**
     * 默认当前页
     */
    private final static int DEFAULT_CURRENT_PAGE = 1;

    /**
     * 将mybatis的分页数据转化为我们需要的page
     *
     * @param page mybatis的分页数据
     * @return 返回的pageVO
     */
    public PageList<V> convert(IPage<T> page) {
        long size = page.getSize() > 0 ? page.getSize() : DEFAULT_SIZE;
        long currentPage = page.getCurrent() > 0 ? page.getCurrent() : DEFAULT_CURRENT_PAGE;
        List<V> voList = page.getRecords().stream().map(this::convertToVO).collect(Collectors.toList());
        PageList<V> pageList = new PageList<>();
        pageList.setCurrentPage(currentPage)
                .setTotal(page.getTotal())
                .setLimit(size)
                .setDataList(voList);
        return pageList;
    }

    /**
     * entity转换为vo
     *
     * @param entity 实体类
     * @return 返回的vo
     */
    public abstract V convertToVO(T entity);
}
