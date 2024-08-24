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

import com.cl.entity.XinliwenzhangEntity;
import com.cl.entity.view.XinliwenzhangView;

import com.cl.service.XinliwenzhangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 心理文章
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
@RestController
@RequestMapping("/xinliwenzhang")
public class XinliwenzhangController {
    @Autowired
    private XinliwenzhangService xinliwenzhangService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XinliwenzhangEntity xinliwenzhang,
		HttpServletRequest request){
        EntityWrapper<XinliwenzhangEntity> ew = new EntityWrapper<XinliwenzhangEntity>();

		PageUtils page = xinliwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinliwenzhang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XinliwenzhangEntity xinliwenzhang, 
		HttpServletRequest request){
        EntityWrapper<XinliwenzhangEntity> ew = new EntityWrapper<XinliwenzhangEntity>();

		PageUtils page = xinliwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinliwenzhang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XinliwenzhangEntity xinliwenzhang){
       	EntityWrapper<XinliwenzhangEntity> ew = new EntityWrapper<XinliwenzhangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xinliwenzhang, "xinliwenzhang")); 
        return R.ok().put("data", xinliwenzhangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XinliwenzhangEntity xinliwenzhang){
        EntityWrapper< XinliwenzhangEntity> ew = new EntityWrapper< XinliwenzhangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xinliwenzhang, "xinliwenzhang")); 
		XinliwenzhangView xinliwenzhangView =  xinliwenzhangService.selectView(ew);
		return R.ok("查询心理文章成功").put("data", xinliwenzhangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XinliwenzhangEntity xinliwenzhang = xinliwenzhangService.selectById(id);
		xinliwenzhang = xinliwenzhangService.selectView(new EntityWrapper<XinliwenzhangEntity>().eq("id", id));
        return R.ok().put("data", xinliwenzhang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XinliwenzhangEntity xinliwenzhang = xinliwenzhangService.selectById(id);
		xinliwenzhang = xinliwenzhangService.selectView(new EntityWrapper<XinliwenzhangEntity>().eq("id", id));
        return R.ok().put("data", xinliwenzhang);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        XinliwenzhangEntity xinliwenzhang = xinliwenzhangService.selectById(id);
        if(type.equals("1")) {
        	xinliwenzhang.setThumbsupnum(xinliwenzhang.getThumbsupnum()+1);
        } else {
        	xinliwenzhang.setCrazilynum(xinliwenzhang.getCrazilynum()+1);
        }
        xinliwenzhangService.updateById(xinliwenzhang);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XinliwenzhangEntity xinliwenzhang, HttpServletRequest request){
    	xinliwenzhang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinliwenzhang);
        xinliwenzhangService.insert(xinliwenzhang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XinliwenzhangEntity xinliwenzhang, HttpServletRequest request){
    	xinliwenzhang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinliwenzhang);
        xinliwenzhangService.insert(xinliwenzhang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XinliwenzhangEntity xinliwenzhang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinliwenzhang);
        xinliwenzhangService.updateById(xinliwenzhang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xinliwenzhangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
