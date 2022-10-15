package com.cf.tencentqq.service.impl;

import com.cf.tencentqq.entity.Starinfo;
import com.cf.tencentqq.dao.StarinfoDao;
import com.cf.tencentqq.service.StarinfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Starinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-10-06 10:48:17
 */
@Service("starinfoService")
public class StarinfoServiceImpl implements StarinfoService {
    @Resource
    private StarinfoDao starinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Starinfo queryById(Integer id) {
        return this.starinfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param starinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Starinfo> queryByPage(Starinfo starinfo, PageRequest pageRequest) {
        long total = this.starinfoDao.count(starinfo);
        return new PageImpl<>(this.starinfoDao.queryAllByLimit(starinfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param starinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Starinfo insert(Starinfo starinfo) {
        this.starinfoDao.insert(starinfo);
        return starinfo;
    }

    /**
     * 修改数据
     *
     * @param starinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Starinfo update(Starinfo starinfo) {
        this.starinfoDao.update(starinfo);
        return this.queryById(starinfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.starinfoDao.deleteById(id) > 0;
    }
}
