package com.cf.tencentqq.controller;

import com.cf.tencentqq.entity.Friendsinfo;
import com.cf.tencentqq.service.FriendsinfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Friendsinfo)表控制层
 *
 * @author makejava
 * @since 2022-10-06 10:49:27
 */
@RestController
@RequestMapping("friendsinfo")
public class FriendsinfoController {
    /**
     * 服务对象
     */
    @Resource
    private FriendsinfoService friendsinfoService;

    /**
     * 分页查询
     *
     * @param friendsinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Friendsinfo>> queryByPage(Friendsinfo friendsinfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.friendsinfoService.queryByPage(friendsinfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Friendsinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.friendsinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param friendsinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Friendsinfo> add(Friendsinfo friendsinfo) {
        return ResponseEntity.ok(this.friendsinfoService.insert(friendsinfo));
    }

    /**
     * 编辑数据
     *
     * @param friendsinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Friendsinfo> edit(Friendsinfo friendsinfo) {
        return ResponseEntity.ok(this.friendsinfoService.update(friendsinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.friendsinfoService.deleteById(id));
    }

}

