package com.unis.x3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unis.x3.model.common.ErrorMsg;
import com.unis.x3.model.common.Result;
import com.unis.x3.service.X3EsbService;

import cn.hutool.db.Entity;
import cn.hutool.db.Page;

/**
 * 
 * @author 胡晓聪
 * @description x3查询controler
 *
 */
@Controller
@RequestMapping("/x3")
public class X3EsbController {
	// 引入service类
	@Autowired
	private X3EsbService service;
	//分页最大条数
	@Value("${page.max.size}")
	private long pageMaxSize;
	//普通查询最大条数
	@Value("${query.max.size}")
	private long queryMaxSize;

	/**
	 * 
	 * @return 说明页面
	 */
	@ResponseBody
	@RequestMapping("")
	public String index() {
		
		return "Stay hungry,Stay foolish.";

	}

	/**
	 * 
	 * @param view        视图名或table名 默认值：v_mes_gdlx_p
	 * @param condition   条件符合oracle sql语法即可 默认值 1=1
	 * @param startRecord 开始记录索引 默认值 1
	 * @param count       查询记录条数 默认值 20 限制最多1000
	 * @return
	 * @throws Exception
	 */
	
	@GetMapping("/pageQuery")
	@ResponseBody
	public Result pageQueryBysql(@RequestParam(name = "view", defaultValue = "v_mes_gdlx_p") String view,
			@RequestParam(name = "where", defaultValue = "1=1") String condition,
			@RequestParam(name = "startRecord", defaultValue = "1") Long startRecord,
			@RequestParam(name = "count", defaultValue = "20") Long count) throws Exception {
		if (count > pageMaxSize) {
			return new Result(false, ErrorMsg.ERR_002, null);
		}
		String sql = "select * from " + view + " where " + condition;
		String pageCon = "where rownum_ between " + startRecord + " and " + (startRecord + count - 1);
		StringBuilder sb = new StringBuilder();
		sb.append("select * from ( SELECT row_.*, rownum rownum_ from ( ").append(sql).append(")  row_ ) table_alias ")
				.append(pageCon);
		List<Entity> data = service.pageQueryBySql(sb.toString(), new Page());
		return new Result(data);
	}

	/**
	 * 
	 * @param view      视图名或table名 默认值：v_mes_gdlx_p
	 * @param condition 条件符合oracle sql语法即可 默认值 1=1
	 * @return
	 * @throws Exception
	 */
	
	@GetMapping("/commonQuery")
	@ResponseBody
	public Result commonQueryBysql(@RequestParam(name = "view", defaultValue = "v_mes_gdlx_p") String view,
			@RequestParam(name = "where", defaultValue = "1=1") String condition) throws Exception {
		String sqlCnt = "select count(1) cnt from " + view + " where " + condition;
		Long cnt = service.count(sqlCnt);
		if (cnt > queryMaxSize) {
			return new Result(false, ErrorMsg.ERR_001);
		}
		String sql = "select * from " + view + " where " + condition;
		List<Entity> data = service.commonQueryBySql(sql);
		return new Result(data);
	}
}
