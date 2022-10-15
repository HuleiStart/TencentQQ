package com.cf.tencentqq.controller;

import com.cf.tencentqq.entity.Questioninfo;
import com.cf.tencentqq.service.QuestioninfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Questioninfo)表控制层
 *
 * @author makejava
 * @since 2022-10-06 10:48:32
 */
@RestController
@RequestMapping("questioninfo")
public class QuestioninfoController {
    /**
     * 服务对象
     */
    @Resource
    private QuestioninfoService questioninfoService;

    /**
     * 分页查询
     *
     * @param questioninfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Questioninfo>> queryByPage(Questioninfo questioninfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.questioninfoService.queryByPage(questioninfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Questioninfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.questioninfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param questioninfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Questioninfo> add(Questioninfo questioninfo) {
        return ResponseEntity.ok(this.questioninfoService.insert(questioninfo));
    }

    /**
     * 编辑数据
     *
     * @param questioninfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Questioninfo> edit(Questioninfo questioninfo) {
        return ResponseEntity.ok(this.questioninfoService.update(questioninfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.questioninfoService.deleteById(id));
    }

}

