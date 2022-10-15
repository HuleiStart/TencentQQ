package com.cf.tencentqq.service.impl;

import com.cf.tencentqq.entity.Messagetypeinfo;
import com.cf.tencentqq.dao.MessagetypeinfoDao;
import com.cf.tencentqq.service.MessagetypeinfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Messagetypeinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-10-06 10:48:45
 */
@Service("messagetypeinfoService")
public class MessagetypeinfoServiceImpl implements MessagetypeinfoService {
    @Resource
    private MessagetypeinfoDao messagetypeinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Messagetypeinfo queryById(Integer id) {
        return this.messagetypeinfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param messagetypeinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Messagetypeinfo> queryByPage(Messagetypeinfo messagetypeinfo, PageRequest pageRequest) {
        long total = this.messagetypeinfoDao.count(messagetypeinfo);
        return new PageImpl<>(this.messagetypeinfoDao.queryAllByLimit(messagetypeinfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param messagetypeinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Messagetypeinfo insert(Messagetypeinfo messagetypeinfo) {
        this.messagetypeinfoDao.insert(messagetypeinfo);
        return messagetypeinfo;
    }

    /**
     * 修改数据
     *
     * @param messagetypeinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Messagetypeinfo update(Messagetypeinfo messagetypeinfo) {
        this.messagetypeinfoDao.update(messagetypeinfo);
        return this.queryById(messagetypeinfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.messagetypeinfoDao.deleteById(id) > 0;
    }
}
