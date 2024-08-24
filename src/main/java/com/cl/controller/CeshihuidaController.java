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

import com.cl.entity.CeshihuidaEntity;
import com.cl.entity.view.CeshihuidaView;

import com.cl.service.CeshihuidaService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 测试回答
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
@RestController
@RequestMapping("/ceshihuida")
public class CeshihuidaController {
    @Autowired
    private CeshihuidaService ceshihuidaService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CeshihuidaEntity ceshihuida,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			ceshihuida.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<CeshihuidaEntity> ew = new EntityWrapper<CeshihuidaEntity>();

		PageUtils page = ceshihuidaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ceshihuida), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CeshihuidaEntity ceshihuida, 
		HttpServletRequest request){
        EntityWrapper<CeshihuidaEntity> ew = new EntityWrapper<CeshihuidaEntity>();

		PageUtils page = ceshihuidaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ceshihuida), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CeshihuidaEntity ceshihuida){
       	EntityWrapper<CeshihuidaEntity> ew = new EntityWrapper<CeshihuidaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ceshihuida, "ceshihuida")); 
        return R.ok().put("data", ceshihuidaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CeshihuidaEntity ceshihuida){
        EntityWrapper< CeshihuidaEntity> ew = new EntityWrapper< CeshihuidaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ceshihuida, "ceshihuida")); 
		CeshihuidaView ceshihuidaView =  ceshihuidaService.selectView(ew);
		return R.ok("查询测试回答成功").put("data", ceshihuidaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CeshihuidaEntity ceshihuida = ceshihuidaService.selectById(id);
		ceshihuida = ceshihuidaService.selectView(new EntityWrapper<CeshihuidaEntity>().eq("id", id));
        return R.ok().put("data", ceshihuida);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CeshihuidaEntity ceshihuida = ceshihuidaService.selectById(id);
		ceshihuida = ceshihuidaService.selectView(new EntityWrapper<CeshihuidaEntity>().eq("id", id));
        return R.ok().put("data", ceshihuida);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CeshihuidaEntity ceshihuida, HttpServletRequest request){
    	ceshihuida.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ceshihuida);
        ceshihuidaService.insert(ceshihuida);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CeshihuidaEntity ceshihuida, HttpServletRequest request){
    	ceshihuida.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ceshihuida);
        ceshihuidaService.insert(ceshihuida);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CeshihuidaEntity ceshihuida, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ceshihuida);
        ceshihuidaService.updateById(ceshihuida);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ceshihuidaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
