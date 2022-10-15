package com.cf.tencentqq.controller;

import com.cf.tencentqq.entity.Anam;
import com.cf.tencentqq.service.AnamService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Anam)表控制层
 *
 * @author makejava
 * @since 2022-10-06 10:50:21
 */
@RestController
@RequestMapping("anam")
public class AnamController {
    /**
     * 服务对象
     */
    @Resource
    private AnamService anamService;

    /**
     * 分页查询
     *
     * @param anam 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Anam>> queryByPage(Anam anam, PageRequest pageRequest) {
        return ResponseEntity.ok(this.anamService.queryByPage(anam, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Anam> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.anamService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param anam 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Anam> add(Anam anam) {
        return ResponseEntity.ok(this.anamService.insert(anam));
    }

    /**
     * 编辑数据
     *
     * @param anam 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Anam> edit(Anam anam) {
        return ResponseEntity.ok(this.anamService.update(anam));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.anamService.deleteById(id));
    }

}

