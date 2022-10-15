package com.cf.tencentqq.service.impl;

import com.cf.tencentqq.entity.Userinfo;
import com.cf.tencentqq.dao.UserinfoDao;
import com.cf.tencentqq.service.UserinfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Userinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-10-06 10:45:50
 */
@Service("userinfoService")
public class UserinfoServiceImpl implements UserinfoService {
    @Resource
    private UserinfoDao userinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Userinfo queryById(Integer id) {
        return this.userinfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param userinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Userinfo> queryByPage(Userinfo userinfo, PageRequest pageRequest) {
        long total = this.userinfoDao.count(userinfo);
        return new PageImpl<>(this.userinfoDao.queryAllByLimit(userinfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param userinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Userinfo insert(Userinfo userinfo) {
        this.userinfoDao.insert(userinfo);
        return userinfo;
    }

    /**
     * 修改数据
     *
     * @param userinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Userinfo update(Userinfo userinfo) {
        this.userinfoDao.update(userinfo);
        return this.queryById(userinfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userinfoDao.deleteById(id) > 0;
    }
}
