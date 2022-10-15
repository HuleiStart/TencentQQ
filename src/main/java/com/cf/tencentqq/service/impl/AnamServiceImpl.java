package com.cf.tencentqq.service.impl;

import com.cf.tencentqq.entity.Anam;
import com.cf.tencentqq.dao.AnamDao;
import com.cf.tencentqq.service.AnamService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Anam)表服务实现类
 *
 * @author makejava
 * @since 2022-10-06 10:50:21
 */
@Service("anamService")
public class AnamServiceImpl implements AnamService {
    @Resource
    private AnamDao anamDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Anam queryById(Integer id) {
        return this.anamDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param anam 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Anam> queryByPage(Anam anam, PageRequest pageRequest) {
        long total = this.anamDao.count(anam);
        return new PageImpl<>(this.anamDao.queryAllByLimit(anam, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param anam 实例对象
     * @return 实例对象
     */
    @Override
    public Anam insert(Anam anam) {
        this.anamDao.insert(anam);
        return anam;
    }

    /**
     * 修改数据
     *
     * @param anam 实例对象
     * @return 实例对象
     */
    @Override
    public Anam update(Anam anam) {
        this.anamDao.update(anam);
        return this.queryById(anam.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.anamDao.deleteById(id) > 0;
    }
}
