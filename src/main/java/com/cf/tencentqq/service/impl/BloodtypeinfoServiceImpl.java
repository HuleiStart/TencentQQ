package com.cf.tencentqq.service.impl;

import com.cf.tencentqq.entity.Bloodtypeinfo;
import com.cf.tencentqq.dao.BloodtypeinfoDao;
import com.cf.tencentqq.service.BloodtypeinfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Bloodtypeinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-10-06 10:49:56
 */
@Service("bloodtypeinfoService")
public class BloodtypeinfoServiceImpl implements BloodtypeinfoService {
    @Resource
    private BloodtypeinfoDao bloodtypeinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Bloodtypeinfo queryById(Integer id) {
        return this.bloodtypeinfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param bloodtypeinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Bloodtypeinfo> queryByPage(Bloodtypeinfo bloodtypeinfo, PageRequest pageRequest) {
        long total = this.bloodtypeinfoDao.count(bloodtypeinfo);
        return new PageImpl<>(this.bloodtypeinfoDao.queryAllByLimit(bloodtypeinfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param bloodtypeinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Bloodtypeinfo insert(Bloodtypeinfo bloodtypeinfo) {
        this.bloodtypeinfoDao.insert(bloodtypeinfo);
        return bloodtypeinfo;
    }

    /**
     * 修改数据
     *
     * @param bloodtypeinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Bloodtypeinfo update(Bloodtypeinfo bloodtypeinfo) {
        this.bloodtypeinfoDao.update(bloodtypeinfo);
        return this.queryById(bloodtypeinfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.bloodtypeinfoDao.deleteById(id) > 0;
    }
}
