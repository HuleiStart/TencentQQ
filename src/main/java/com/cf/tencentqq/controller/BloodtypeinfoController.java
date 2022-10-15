package com.cf.tencentqq.controller;

import com.cf.tencentqq.entity.Bloodtypeinfo;
import com.cf.tencentqq.service.BloodtypeinfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Bloodtypeinfo)表控制层
 *
 * @author makejava
 * @since 2022-10-06 10:49:56
 */
@RestController
@RequestMapping("bloodtypeinfo")
public class BloodtypeinfoController {
    /**
     * 服务对象
     */
    @Resource
    private BloodtypeinfoService bloodtypeinfoService;

    /**
     * 分页查询
     *
     * @param bloodtypeinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Bloodtypeinfo>> queryByPage(Bloodtypeinfo bloodtypeinfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.bloodtypeinfoService.queryByPage(bloodtypeinfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Bloodtypeinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.bloodtypeinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param bloodtypeinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Bloodtypeinfo> add(Bloodtypeinfo bloodtypeinfo) {
        return ResponseEntity.ok(this.bloodtypeinfoService.insert(bloodtypeinfo));
    }

    /**
     * 编辑数据
     *
     * @param bloodtypeinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Bloodtypeinfo> edit(Bloodtypeinfo bloodtypeinfo) {
        return ResponseEntity.ok(this.bloodtypeinfoService.update(bloodtypeinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.bloodtypeinfoService.deleteById(id));
    }

}

