package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.XinliceshiEntity;
import com.cl.entity.view.XinliceshiView;

import com.cl.service.XinliceshiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 心理测试
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
@RestController
@RequestMapping("/xinliceshi")
public class XinliceshiController {
    @Autowired
    private XinliceshiService xinliceshiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XinliceshiEntity xinliceshi,
		HttpServletRequest request){
        EntityWrapper<XinliceshiEntity> ew = new EntityWrapper<XinliceshiEntity>();

		PageUtils page = xinliceshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinliceshi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XinliceshiEntity xinliceshi, 
		HttpServletRequest request){
        EntityWrapper<XinliceshiEntity> ew = new EntityWrapper<XinliceshiEntity>();

		PageUtils page = xinliceshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinliceshi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XinliceshiEntity xinliceshi){
       	EntityWrapper<XinliceshiEntity> ew = new EntityWrapper<XinliceshiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xinliceshi, "xinliceshi")); 
        return R.ok().put("data", xinliceshiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XinliceshiEntity xinliceshi){
        EntityWrapper< XinliceshiEntity> ew = new EntityWrapper< XinliceshiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xinliceshi, "xinliceshi")); 
		XinliceshiView xinliceshiView =  xinliceshiService.selectView(ew);
		return R.ok("查询心理测试成功").put("data", xinliceshiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XinliceshiEntity xinliceshi = xinliceshiService.selectById(id);
		xinliceshi = xinliceshiService.selectView(new EntityWrapper<XinliceshiEntity>().eq("id", id));
        return R.ok().put("data", xinliceshi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XinliceshiEntity xinliceshi = xinliceshiService.selectById(id);
		xinliceshi = xinliceshiService.selectView(new EntityWrapper<XinliceshiEntity>().eq("id", id));
        return R.ok().put("data", xinliceshi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XinliceshiEntity xinliceshi, HttpServletRequest request){
    	xinliceshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinliceshi);
        xinliceshiService.insert(xinliceshi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XinliceshiEntity xinliceshi, HttpServletRequest request){
    	xinliceshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinliceshi);
        xinliceshiService.insert(xinliceshi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XinliceshiEntity xinliceshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinliceshi);
        xinliceshiService.updateById(xinliceshi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xinliceshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
