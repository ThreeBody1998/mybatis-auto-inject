package com.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.enums.HttpResultEnum;
import com.demo.pojo.custom.IdsWrapper;
import com.demo.pojo.custom.ResponseResult;
import com.demo.pojo.dto.UserInsertDTO;
import com.demo.pojo.dto.UserPageDTO;
import com.demo.pojo.entity.User;
import com.demo.pojo.vo.PageList;
import com.demo.pojo.vo.UserPageVO;
import com.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * description  用户Controller
 * @author 周建泽
 * @date 2024/1/18
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    /**
     * 新增用户
     * @param userInsertDTO 用户信息
     * @return  新增结果
     */
    @PostMapping("/insert")
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult<String> insert(@RequestBody @Valid UserInsertDTO userInsertDTO){
        ResponseResult<String> responseResult=new ResponseResult<>();
        User user=userInsertDTO.translate2Entity();
        boolean insertResult=userService.save(user);
        return insertResult?responseResult.setHttpResultEnum(HttpResultEnum.SUCCESS):responseResult.setHttpResultEnum(HttpResultEnum.INSERT_FAIL);
    }

    /**
     * 批量删除用户
     * @param idsWrapper    id集合
     * @return  操作结果
     */
    @PutMapping("/batchDelete")
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult<String> batchDelete(@RequestBody @Valid IdsWrapper idsWrapper){
        ResponseResult<String> responseResult=new ResponseResult<>();
        boolean deleteResult=userService.removeByIds(idsWrapper.getIds());
        return deleteResult?responseResult.setHttpResultEnum(HttpResultEnum.SUCCESS):responseResult.setHttpResultEnum(HttpResultEnum.DELETE_FAIL);
    }

    /**
     * 分页查询用户
     * @param userPageDTO   查询条件
     * @return  用户信息
     */
    @GetMapping("/page")
    public ResponseResult<PageList<UserPageVO>> page(@Valid UserPageDTO userPageDTO){
        ResponseResult<PageList<UserPageVO>> responseResult=new ResponseResult<>();
        Page<User> page=userService.page(userPageDTO);
        return responseResult.setHttpResultEnum(HttpResultEnum.SUCCESS).setData(new UserPageVO().convert(page));
    }
}
