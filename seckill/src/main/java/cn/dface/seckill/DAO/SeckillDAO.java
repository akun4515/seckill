package cn.dface.seckill.DAO;

import java.util.Date;

import cn.dface.seckill.entity.SeckillDo;

public interface SeckillDAO {
	
	public void insert(SeckillDo seckillDo);
	
	/**
	 * 剪库存
	 * @param seckillId
	 * @param killTime
	 * @return
	 */
	public Integer reduceNumber(Long seckillId,Date killTime);
	
	/**
	 * 查询秒杀
	 * @param seckillId
	 * @return
	 */
	public SeckillDo queryById(Long seckillId);
}	
