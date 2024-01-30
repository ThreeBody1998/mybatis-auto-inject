package com.demo.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.demo.util.ContextUtil;
import com.demo.util.DateTools;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;


/**
 * description mybatis自定义处理器
 * @author 周建泽
 * @date 2024/1/18
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 没有被逻辑删除的标志
     */
    private static final int NOT_DELETE_FLAG = 0;
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createAt", String.class,DateTools.getCurrentTime());
        this.strictInsertFill(metaObject, "createBy", String.class,ContextUtil.getCurrentUserId());
        this.strictInsertFill(metaObject, "isDelete", Integer.class,NOT_DELETE_FLAG);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "updateAt", DateTools.getCurrentTime());
        this.fillStrategy(metaObject, "updateBy", ContextUtil.getCurrentUserId());
    }
}
