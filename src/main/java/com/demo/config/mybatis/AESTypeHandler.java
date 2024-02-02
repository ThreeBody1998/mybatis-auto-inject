package com.demo.config.mybatis;

import com.demo.util.AESUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * description AES类型转换器
 *
 * @author 周建泽
 * @date 2024/1/30
 */
public class AESTypeHandler extends BaseTypeHandler<String> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, AESUtil.encrypt(s));
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return AESUtil.decrypt(resultSet.getString(s));
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return AESUtil.decrypt(resultSet.getString(i));
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return AESUtil.decrypt(callableStatement.getString(i));
    }
}
