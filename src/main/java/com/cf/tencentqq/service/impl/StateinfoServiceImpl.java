package com.cf.tencentqq.service.impl;

import com.cf.tencentqq.entity.Stateinfo;
import com.cf.tencentqq.dao.StateinfoDao;
import com.cf.tencentqq.service.StateinfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Stateinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-10-06 10:48:01
 */
@Service("stateinfoService")
public class StateinfoServiceImpl implements StateinfoService {
    @Resource
    private StateinfoDao stateinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Stateinfo queryById(Integer id) {
        return this.stateinfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param stateinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Stateinfo> queryByPage(Stateinfo stateinfo, PageRequest pageRequest) {
        long total = this.stateinfoDao.count(stateinfo);
        return new PageImpl<>(this.stateinfoDao.queryAllByLimit(stateinfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param stateinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Stateinfo insert(Stateinfo stateinfo) {
        this.stateinfoDao.insert(stateinfo);
        return stateinfo;
    }

    /**
     * 修改数据
     *
     * @param stateinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Stateinfo update(Stateinfo stateinfo) {
        this.stateinfoDao.update(stateinfo);
        return this.queryById(stateinfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.stateinfoDao.deleteById(id) > 0;
    }
}
