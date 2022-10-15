package com.cf.tencentqq.controller;

import com.cf.tencentqq.entity.Messagesinfo;
import com.cf.tencentqq.service.MessagesinfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Messagesinfo)表控制层
 *
 * @author makejava
 * @since 2022-10-06 10:49:06
 */
@RestController
@RequestMapping("messagesinfo")
public class MessagesinfoController {
    /**
     * 服务对象
     */
    @Resource
    private MessagesinfoService messagesinfoService;

    /**
     * 分页查询
     *
     * @param messagesinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Messagesinfo>> queryByPage(Messagesinfo messagesinfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.messagesinfoService.queryByPage(messagesinfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Messagesinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.messagesinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param messagesinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Messagesinfo> add(Messagesinfo messagesinfo) {
        return ResponseEntity.ok(this.messagesinfoService.insert(messagesinfo));
    }

    /**
     * 编辑数据
     *
     * @param messagesinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Messagesinfo> edit(Messagesinfo messagesinfo) {
        return ResponseEntity.ok(this.messagesinfoService.update(messagesinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.messagesinfoService.deleteById(id));
    }

}

