package com.cf.tencentqq.controller;

import com.cf.tencentqq.entity.Stateinfo;
import com.cf.tencentqq.service.StateinfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Stateinfo)表控制层
 *
 * @author makejava
 * @since 2022-10-06 10:48:01
 */
@RestController
@RequestMapping("stateinfo")
public class StateinfoController {
    /**
     * 服务对象
     */
    @Resource
    private StateinfoService stateinfoService;

    /**
     * 分页查询
     *
     * @param stateinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Stateinfo>> queryByPage(Stateinfo stateinfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.stateinfoService.queryByPage(stateinfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Stateinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.stateinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param stateinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Stateinfo> add(Stateinfo stateinfo) {
        return ResponseEntity.ok(this.stateinfoService.insert(stateinfo));
    }

    /**
     * 编辑数据
     *
     * @param stateinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Stateinfo> edit(Stateinfo stateinfo) {
        return ResponseEntity.ok(this.stateinfoService.update(stateinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.stateinfoService.deleteById(id));
    }

}

