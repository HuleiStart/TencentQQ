package com.cf.tencentqq.controller;

import com.cf.tencentqq.entity.Starinfo;
import com.cf.tencentqq.service.StarinfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Starinfo)表控制层
 *
 * @author makejava
 * @since 2022-10-06 10:48:17
 */
@RestController
@RequestMapping("starinfo")
public class StarinfoController {
    /**
     * 服务对象
     */
    @Resource
    private StarinfoService starinfoService;

    /**
     * 分页查询
     *
     * @param starinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Starinfo>> queryByPage(Starinfo starinfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.starinfoService.queryByPage(starinfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Starinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.starinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param starinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Starinfo> add(Starinfo starinfo) {
        return ResponseEntity.ok(this.starinfoService.insert(starinfo));
    }

    /**
     * 编辑数据
     *
     * @param starinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Starinfo> edit(Starinfo starinfo) {
        return ResponseEntity.ok(this.starinfoService.update(starinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.starinfoService.deleteById(id));
    }

}

