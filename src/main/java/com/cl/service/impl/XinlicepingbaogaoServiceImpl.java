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


import com.cl.dao.XinlicepingbaogaoDao;
import com.cl.entity.XinlicepingbaogaoEntity;
import com.cl.service.XinlicepingbaogaoService;
import com.cl.entity.view.XinlicepingbaogaoView;

@Service("xinlicepingbaogaoService")
public class XinlicepingbaogaoServiceImpl extends ServiceImpl<XinlicepingbaogaoDao, XinlicepingbaogaoEntity> implements XinlicepingbaogaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XinlicepingbaogaoEntity> page = this.selectPage(
                new Query<XinlicepingbaogaoEntity>(params).getPage(),
                new EntityWrapper<XinlicepingbaogaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XinlicepingbaogaoEntity> wrapper) {
		  Page<XinlicepingbaogaoView> page =new Query<XinlicepingbaogaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XinlicepingbaogaoView> selectListView(Wrapper<XinlicepingbaogaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XinlicepingbaogaoView selectView(Wrapper<XinlicepingbaogaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<XinlicepingbaogaoEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<XinlicepingbaogaoEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<XinlicepingbaogaoEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
