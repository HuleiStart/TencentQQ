package com.cf.tencentqq.controller;

import com.cf.tencentqq.entity.Friendshippolicyinfo;
import com.cf.tencentqq.service.FriendshippolicyinfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Friendshippolicyinfo)表控制层
 *
 * @author makejava
 * @since 2022-10-06 10:49:44
 */
@RestController
@RequestMapping("friendshippolicyinfo")
public class FriendshippolicyinfoController {
    /**
     * 服务对象
     */
    @Resource
    private FriendshippolicyinfoService friendshippolicyinfoService;

    /**
     * 分页查询
     *
     * @param friendshippolicyinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Friendshippolicyinfo>> queryByPage(Friendshippolicyinfo friendshippolicyinfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.friendshippolicyinfoService.queryByPage(friendshippolicyinfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Friendshippolicyinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.friendshippolicyinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param friendshippolicyinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Friendshippolicyinfo> add(Friendshippolicyinfo friendshippolicyinfo) {
        return ResponseEntity.ok(this.friendshippolicyinfoService.insert(friendshippolicyinfo));
    }

    /**
     * 编辑数据
     *
     * @param friendshippolicyinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Friendshippolicyinfo> edit(Friendshippolicyinfo friendshippolicyinfo) {
        return ResponseEntity.ok(this.friendshippolicyinfoService.update(friendshippolicyinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.friendshippolicyinfoService.deleteById(id));
    }

}

