package com.cf.tencentqq.service.impl;

import com.cf.tencentqq.entity.Animalyearinfo;
import com.cf.tencentqq.dao.AnimalyearinfoDao;
import com.cf.tencentqq.service.AnimalyearinfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Animalyearinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-10-06 10:50:09
 */
@Service("animalyearinfoService")
public class AnimalyearinfoServiceImpl implements AnimalyearinfoService {
    @Resource
    private AnimalyearinfoDao animalyearinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Animalyearinfo queryById(Integer id) {
        return this.animalyearinfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param animalyearinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Animalyearinfo> queryByPage(Animalyearinfo animalyearinfo, PageRequest pageRequest) {
        long total = this.animalyearinfoDao.count(animalyearinfo);
        return new PageImpl<>(this.animalyearinfoDao.queryAllByLimit(animalyearinfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param animalyearinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Animalyearinfo insert(Animalyearinfo animalyearinfo) {
        this.animalyearinfoDao.insert(animalyearinfo);
        return animalyearinfo;
    }

    /**
     * 修改数据
     *
     * @param animalyearinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Animalyearinfo update(Animalyearinfo animalyearinfo) {
        this.animalyearinfoDao.update(animalyearinfo);
        return this.queryById(animalyearinfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.animalyearinfoDao.deleteById(id) > 0;
    }
}
