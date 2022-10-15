package com.cf.tencentqq.controller;

import com.cf.tencentqq.entity.Messagetypeinfo;
import com.cf.tencentqq.service.MessagetypeinfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Messagetypeinfo)表控制层
 *
 * @author makejava
 * @since 2022-10-06 10:48:45
 */
@RestController
@RequestMapping("messagetypeinfo")
public class MessagetypeinfoController {
    /**
     * 服务对象
     */
    @Resource
    private MessagetypeinfoService messagetypeinfoService;

    /**
     * 分页查询
     *
     * @param messagetypeinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Messagetypeinfo>> queryByPage(Messagetypeinfo messagetypeinfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.messagetypeinfoService.queryByPage(messagetypeinfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Messagetypeinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.messagetypeinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param messagetypeinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Messagetypeinfo> add(Messagetypeinfo messagetypeinfo) {
        return ResponseEntity.ok(this.messagetypeinfoService.insert(messagetypeinfo));
    }

    /**
     * 编辑数据
     *
     * @param messagetypeinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Messagetypeinfo> edit(Messagetypeinfo messagetypeinfo) {
        return ResponseEntity.ok(this.messagetypeinfoService.update(messagetypeinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.messagetypeinfoService.deleteById(id));
    }

}

