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


import com.cl.dao.XinliceshiDao;
import com.cl.entity.XinliceshiEntity;
import com.cl.service.XinliceshiService;
import com.cl.entity.view.XinliceshiView;

@Service("xinliceshiService")
public class XinliceshiServiceImpl extends ServiceImpl<XinliceshiDao, XinliceshiEntity> implements XinliceshiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XinliceshiEntity> page = this.selectPage(
                new Query<XinliceshiEntity>(params).getPage(),
                new EntityWrapper<XinliceshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XinliceshiEntity> wrapper) {
		  Page<XinliceshiView> page =new Query<XinliceshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XinliceshiView> selectListView(Wrapper<XinliceshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XinliceshiView selectView(Wrapper<XinliceshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
