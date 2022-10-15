package com.cf.tencentqq.service.impl;

import com.cf.tencentqq.entity.Friendshippolicyinfo;
import com.cf.tencentqq.dao.FriendshippolicyinfoDao;
import com.cf.tencentqq.service.FriendshippolicyinfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Friendshippolicyinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-10-06 10:49:44
 */
@Service("friendshippolicyinfoService")
public class FriendshippolicyinfoServiceImpl implements FriendshippolicyinfoService {
    @Resource
    private FriendshippolicyinfoDao friendshippolicyinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Friendshippolicyinfo queryById(Integer id) {
        return this.friendshippolicyinfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param friendshippolicyinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Friendshippolicyinfo> queryByPage(Friendshippolicyinfo friendshippolicyinfo, PageRequest pageRequest) {
        long total = this.friendshippolicyinfoDao.count(friendshippolicyinfo);
        return new PageImpl<>(this.friendshippolicyinfoDao.queryAllByLimit(friendshippolicyinfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param friendshippolicyinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Friendshippolicyinfo insert(Friendshippolicyinfo friendshippolicyinfo) {
        this.friendshippolicyinfoDao.insert(friendshippolicyinfo);
        return friendshippolicyinfo;
    }

    /**
     * 修改数据
     *
     * @param friendshippolicyinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Friendshippolicyinfo update(Friendshippolicyinfo friendshippolicyinfo) {
        this.friendshippolicyinfoDao.update(friendshippolicyinfo);
        return this.queryById(friendshippolicyinfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.friendshippolicyinfoDao.deleteById(id) > 0;
    }
}
