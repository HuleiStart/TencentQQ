package com.cf.tencentqq.service.impl;

import com.cf.tencentqq.entity.Friendsinfo;
import com.cf.tencentqq.dao.FriendsinfoDao;
import com.cf.tencentqq.service.FriendsinfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Friendsinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-10-06 10:49:27
 */
@Service("friendsinfoService")
public class FriendsinfoServiceImpl implements FriendsinfoService {
    @Resource
    private FriendsinfoDao friendsinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Friendsinfo queryById(Integer id) {
        return this.friendsinfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param friendsinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Friendsinfo> queryByPage(Friendsinfo friendsinfo, PageRequest pageRequest) {
        long total = this.friendsinfoDao.count(friendsinfo);
        return new PageImpl<>(this.friendsinfoDao.queryAllByLimit(friendsinfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param friendsinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Friendsinfo insert(Friendsinfo friendsinfo) {
        this.friendsinfoDao.insert(friendsinfo);
        return friendsinfo;
    }

    /**
     * 修改数据
     *
     * @param friendsinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Friendsinfo update(Friendsinfo friendsinfo) {
        this.friendsinfoDao.update(friendsinfo);
        return this.queryById(friendsinfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.friendsinfoDao.deleteById(id) > 0;
    }
}
