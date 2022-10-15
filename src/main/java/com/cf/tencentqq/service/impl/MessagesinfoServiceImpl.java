package com.cf.tencentqq.service.impl;

import com.cf.tencentqq.entity.Messagesinfo;
import com.cf.tencentqq.dao.MessagesinfoDao;
import com.cf.tencentqq.service.MessagesinfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Messagesinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-10-06 10:49:06
 */
@Service("messagesinfoService")
public class MessagesinfoServiceImpl implements MessagesinfoService {
    @Resource
    private MessagesinfoDao messagesinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Messagesinfo queryById(Integer id) {
        return this.messagesinfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param messagesinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Messagesinfo> queryByPage(Messagesinfo messagesinfo, PageRequest pageRequest) {
        long total = this.messagesinfoDao.count(messagesinfo);
        return new PageImpl<>(this.messagesinfoDao.queryAllByLimit(messagesinfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param messagesinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Messagesinfo insert(Messagesinfo messagesinfo) {
        this.messagesinfoDao.insert(messagesinfo);
        return messagesinfo;
    }

    /**
     * 修改数据
     *
     * @param messagesinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Messagesinfo update(Messagesinfo messagesinfo) {
        this.messagesinfoDao.update(messagesinfo);
        return this.queryById(messagesinfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.messagesinfoDao.deleteById(id) > 0;
    }
}
