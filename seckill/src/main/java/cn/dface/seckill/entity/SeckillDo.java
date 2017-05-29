package cn.dface.seckill.entity;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SeckillDo {
	
	private Long seckillId;
	private String name;
	private Integer number;
	private Date   startTime;
	private Date   endTime;
	
}
