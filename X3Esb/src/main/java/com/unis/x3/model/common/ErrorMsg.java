package com.unis.x3.model.common;

/**
 * 
 * @author 胡晓聪 ErrorMsg常量类
 *
 */
public class ErrorMsg {
//条数过多错误
	public static final String ERR_001 = "当前条件下数据量较大,请更换条件或者使用分页查询api";
//分页条数过多错误
	public static final String ERR_002 = "分页单页指定条数最多不能超过1000";
//令牌错误
	public static final String ERR_003 = "令牌错误,请确认后重新尝试.";
//404错误
	public static final String ERR_004 = "请求URI不存在,请确认后重新访问.";

}
