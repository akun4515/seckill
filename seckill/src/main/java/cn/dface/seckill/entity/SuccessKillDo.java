package cn.dface.seckill.entity;

import java.util.Date;

import lombok.Data;

@Data
public class SuccessKillDo {
	
	private Long seckillId;
	
	private Long userPhone;
	
	private Short state;
	
	private Date createTime;
	
	private SeckillDo seckill;
}
