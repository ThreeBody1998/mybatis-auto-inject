package com.demo.service.baseInterface;

/**
 * description 分页接口
 * @author 周建泽
 * @date 2024/1/29
 */
public interface PageInterface<T,E> {
    /**
     * description 传入实体类，返回vo
     * @param entity    实体类
     * @return  vo对象
     */
     T translateToVO(E entity);
}
