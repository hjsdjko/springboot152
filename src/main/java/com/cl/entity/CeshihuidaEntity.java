package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 测试回答
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
@TableName("ceshihuida")
public class CeshihuidaEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CeshihuidaEntity() {
		
	}
	
	public CeshihuidaEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 测试名称
	 */
					
	private String ceshimingcheng;
	
	/**
	 * 问题一
	 */
					
	private String wentiyi;
	
	/**
	 * 回答一
	 */
					
	private String huidayi;
	
	/**
	 * 问题二
	 */
					
	private String wentier;
	
	/**
	 * 回答二
	 */
					
	private String huidaer;
	
	/**
	 * 问题三
	 */
					
	private String wentisan;
	
	/**
	 * 回答三
	 */
					
	private String huidasan;
	
	/**
	 * 问题四
	 */
					
	private String wentisi;
	
	/**
	 * 回答四
	 */
					
	private String huidasi;
	
	/**
	 * 问题五
	 */
					
	private String wentiwu;
	
	/**
	 * 回答五
	 */
					
	private String huidawu;
	
	/**
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 学生姓名
	 */
					
	private String xueshengxingming;
	
	/**
	 * 测试时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date ceshishijian;
	
	/**
	 * 跨表用户id
	 */
					
	private Long crossuserid;
	
	/**
	 * 跨表主键id
	 */
					
	private Long crossrefid;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：测试名称
	 */
	public void setCeshimingcheng(String ceshimingcheng) {
		this.ceshimingcheng = ceshimingcheng;
	}
	/**
	 * 获取：测试名称
	 */
	public String getCeshimingcheng() {
		return ceshimingcheng;
	}
	/**
	 * 设置：问题一
	 */
	public void setWentiyi(String wentiyi) {
		this.wentiyi = wentiyi;
	}
	/**
	 * 获取：问题一
	 */
	public String getWentiyi() {
		return wentiyi;
	}
	/**
	 * 设置：回答一
	 */
	public void setHuidayi(String huidayi) {
		this.huidayi = huidayi;
	}
	/**
	 * 获取：回答一
	 */
	public String getHuidayi() {
		return huidayi;
	}
	/**
	 * 设置：问题二
	 */
	public void setWentier(String wentier) {
		this.wentier = wentier;
	}
	/**
	 * 获取：问题二
	 */
	public String getWentier() {
		return wentier;
	}
	/**
	 * 设置：回答二
	 */
	public void setHuidaer(String huidaer) {
		this.huidaer = huidaer;
	}
	/**
	 * 获取：回答二
	 */
	public String getHuidaer() {
		return huidaer;
	}
	/**
	 * 设置：问题三
	 */
	public void setWentisan(String wentisan) {
		this.wentisan = wentisan;
	}
	/**
	 * 获取：问题三
	 */
	public String getWentisan() {
		return wentisan;
	}
	/**
	 * 设置：回答三
	 */
	public void setHuidasan(String huidasan) {
		this.huidasan = huidasan;
	}
	/**
	 * 获取：回答三
	 */
	public String getHuidasan() {
		return huidasan;
	}
	/**
	 * 设置：问题四
	 */
	public void setWentisi(String wentisi) {
		this.wentisi = wentisi;
	}
	/**
	 * 获取：问题四
	 */
	public String getWentisi() {
		return wentisi;
	}
	/**
	 * 设置：回答四
	 */
	public void setHuidasi(String huidasi) {
		this.huidasi = huidasi;
	}
	/**
	 * 获取：回答四
	 */
	public String getHuidasi() {
		return huidasi;
	}
	/**
	 * 设置：问题五
	 */
	public void setWentiwu(String wentiwu) {
		this.wentiwu = wentiwu;
	}
	/**
	 * 获取：问题五
	 */
	public String getWentiwu() {
		return wentiwu;
	}
	/**
	 * 设置：回答五
	 */
	public void setHuidawu(String huidawu) {
		this.huidawu = huidawu;
	}
	/**
	 * 获取：回答五
	 */
	public String getHuidawu() {
		return huidawu;
	}
	/**
	 * 设置：学号
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
	/**
	 * 设置：学生姓名
	 */
	public void setXueshengxingming(String xueshengxingming) {
		this.xueshengxingming = xueshengxingming;
	}
	/**
	 * 获取：学生姓名
	 */
	public String getXueshengxingming() {
		return xueshengxingming;
	}
	/**
	 * 设置：测试时间
	 */
	public void setCeshishijian(Date ceshishijian) {
		this.ceshishijian = ceshishijian;
	}
	/**
	 * 获取：测试时间
	 */
	public Date getCeshishijian() {
		return ceshishijian;
	}
	/**
	 * 设置：跨表用户id
	 */
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
	/**
	 * 设置：跨表主键id
	 */
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}

}
