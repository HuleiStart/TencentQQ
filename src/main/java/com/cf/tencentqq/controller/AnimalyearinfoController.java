package com.cf.tencentqq.controller;

import com.cf.tencentqq.entity.Animalyearinfo;
import com.cf.tencentqq.service.AnimalyearinfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Animalyearinfo)表控制层
 *
 * @author makejava
 * @since 2022-10-06 10:50:09
 */
@RestController
@RequestMapping("animalyearinfo")
public class AnimalyearinfoController {
    /**
     * 服务对象
     */
    @Resource
    private AnimalyearinfoService animalyearinfoService;

    /**
     * 分页查询
     *
     * @param animalyearinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Animalyearinfo>> queryByPage(Animalyearinfo animalyearinfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.animalyearinfoService.queryByPage(animalyearinfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Animalyearinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.animalyearinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param animalyearinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Animalyearinfo> add(Animalyearinfo animalyearinfo) {
        return ResponseEntity.ok(this.animalyearinfoService.insert(animalyearinfo));
    }

    /**
     * 编辑数据
     *
     * @param animalyearinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Animalyearinfo> edit(Animalyearinfo animalyearinfo) {
        return ResponseEntity.ok(this.animalyearinfoService.update(animalyearinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.animalyearinfoService.deleteById(id));
    }

}

