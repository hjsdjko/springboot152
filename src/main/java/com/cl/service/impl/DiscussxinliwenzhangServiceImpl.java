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


import com.cl.dao.DiscussxinliwenzhangDao;
import com.cl.entity.DiscussxinliwenzhangEntity;
import com.cl.service.DiscussxinliwenzhangService;
import com.cl.entity.view.DiscussxinliwenzhangView;

@Service("discussxinliwenzhangService")
public class DiscussxinliwenzhangServiceImpl extends ServiceImpl<DiscussxinliwenzhangDao, DiscussxinliwenzhangEntity> implements DiscussxinliwenzhangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxinliwenzhangEntity> page = this.selectPage(
                new Query<DiscussxinliwenzhangEntity>(params).getPage(),
                new EntityWrapper<DiscussxinliwenzhangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxinliwenzhangEntity> wrapper) {
		  Page<DiscussxinliwenzhangView> page =new Query<DiscussxinliwenzhangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussxinliwenzhangView> selectListView(Wrapper<DiscussxinliwenzhangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxinliwenzhangView selectView(Wrapper<DiscussxinliwenzhangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
