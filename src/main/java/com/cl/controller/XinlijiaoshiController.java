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

import com.cl.entity.XinlijiaoshiEntity;
import com.cl.entity.view.XinlijiaoshiView;

import com.cl.service.XinlijiaoshiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 心理教师
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
@RestController
@RequestMapping("/xinlijiaoshi")
public class XinlijiaoshiController {
    @Autowired
    private XinlijiaoshiService xinlijiaoshiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XinlijiaoshiEntity xinlijiaoshi,
		HttpServletRequest request){
        EntityWrapper<XinlijiaoshiEntity> ew = new EntityWrapper<XinlijiaoshiEntity>();

		PageUtils page = xinlijiaoshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinlijiaoshi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XinlijiaoshiEntity xinlijiaoshi, 
		HttpServletRequest request){
        EntityWrapper<XinlijiaoshiEntity> ew = new EntityWrapper<XinlijiaoshiEntity>();

		PageUtils page = xinlijiaoshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinlijiaoshi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XinlijiaoshiEntity xinlijiaoshi){
       	EntityWrapper<XinlijiaoshiEntity> ew = new EntityWrapper<XinlijiaoshiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xinlijiaoshi, "xinlijiaoshi")); 
        return R.ok().put("data", xinlijiaoshiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XinlijiaoshiEntity xinlijiaoshi){
        EntityWrapper< XinlijiaoshiEntity> ew = new EntityWrapper< XinlijiaoshiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xinlijiaoshi, "xinlijiaoshi")); 
		XinlijiaoshiView xinlijiaoshiView =  xinlijiaoshiService.selectView(ew);
		return R.ok("查询心理教师成功").put("data", xinlijiaoshiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XinlijiaoshiEntity xinlijiaoshi = xinlijiaoshiService.selectById(id);
		xinlijiaoshi = xinlijiaoshiService.selectView(new EntityWrapper<XinlijiaoshiEntity>().eq("id", id));
        return R.ok().put("data", xinlijiaoshi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XinlijiaoshiEntity xinlijiaoshi = xinlijiaoshiService.selectById(id);
		xinlijiaoshi = xinlijiaoshiService.selectView(new EntityWrapper<XinlijiaoshiEntity>().eq("id", id));
        return R.ok().put("data", xinlijiaoshi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XinlijiaoshiEntity xinlijiaoshi, HttpServletRequest request){
    	xinlijiaoshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinlijiaoshi);
        xinlijiaoshiService.insert(xinlijiaoshi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XinlijiaoshiEntity xinlijiaoshi, HttpServletRequest request){
    	xinlijiaoshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinlijiaoshi);
        xinlijiaoshiService.insert(xinlijiaoshi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XinlijiaoshiEntity xinlijiaoshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinlijiaoshi);
        xinlijiaoshiService.updateById(xinlijiaoshi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xinlijiaoshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
