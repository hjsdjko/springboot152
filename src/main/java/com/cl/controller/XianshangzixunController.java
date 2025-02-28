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

import com.cl.entity.XianshangzixunEntity;
import com.cl.entity.view.XianshangzixunView;

import com.cl.service.XianshangzixunService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 线上咨询
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
@RestController
@RequestMapping("/xianshangzixun")
public class XianshangzixunController {
    @Autowired
    private XianshangzixunService xianshangzixunService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XianshangzixunEntity xianshangzixun,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			xianshangzixun.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			xianshangzixun.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XianshangzixunEntity> ew = new EntityWrapper<XianshangzixunEntity>();

		PageUtils page = xianshangzixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianshangzixun), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XianshangzixunEntity xianshangzixun, 
		HttpServletRequest request){
        EntityWrapper<XianshangzixunEntity> ew = new EntityWrapper<XianshangzixunEntity>();

		PageUtils page = xianshangzixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianshangzixun), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XianshangzixunEntity xianshangzixun){
       	EntityWrapper<XianshangzixunEntity> ew = new EntityWrapper<XianshangzixunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xianshangzixun, "xianshangzixun")); 
        return R.ok().put("data", xianshangzixunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XianshangzixunEntity xianshangzixun){
        EntityWrapper< XianshangzixunEntity> ew = new EntityWrapper< XianshangzixunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xianshangzixun, "xianshangzixun")); 
		XianshangzixunView xianshangzixunView =  xianshangzixunService.selectView(ew);
		return R.ok("查询线上咨询成功").put("data", xianshangzixunView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XianshangzixunEntity xianshangzixun = xianshangzixunService.selectById(id);
		xianshangzixun = xianshangzixunService.selectView(new EntityWrapper<XianshangzixunEntity>().eq("id", id));
        return R.ok().put("data", xianshangzixun);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XianshangzixunEntity xianshangzixun = xianshangzixunService.selectById(id);
		xianshangzixun = xianshangzixunService.selectView(new EntityWrapper<XianshangzixunEntity>().eq("id", id));
        return R.ok().put("data", xianshangzixun);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XianshangzixunEntity xianshangzixun, HttpServletRequest request){
    	xianshangzixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xianshangzixun);
        xianshangzixunService.insert(xianshangzixun);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XianshangzixunEntity xianshangzixun, HttpServletRequest request){
    	xianshangzixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xianshangzixun);
        xianshangzixunService.insert(xianshangzixun);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XianshangzixunEntity xianshangzixun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xianshangzixun);
        xianshangzixunService.updateById(xianshangzixun);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xianshangzixunService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
