package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ZixunyuyueDao;
import com.cl.entity.ZixunyuyueEntity;
import com.cl.service.ZixunyuyueService;
import com.cl.entity.view.ZixunyuyueView;

@Service("zixunyuyueService")
public class ZixunyuyueServiceImpl extends ServiceImpl<ZixunyuyueDao, ZixunyuyueEntity> implements ZixunyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZixunyuyueEntity> page = this.selectPage(
                new Query<ZixunyuyueEntity>(params).getPage(),
                new EntityWrapper<ZixunyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZixunyuyueEntity> wrapper) {
		  Page<ZixunyuyueView> page =new Query<ZixunyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZixunyuyueView> selectListView(Wrapper<ZixunyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZixunyuyueView selectView(Wrapper<ZixunyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
