package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YuyuejieyueDao;
import com.entity.YuyuejieyueEntity;
import com.service.YuyuejieyueService;
import com.entity.vo.YuyuejieyueVO;
import com.entity.view.YuyuejieyueView;

@Service("yuyuejieyueService")
public class YuyuejieyueServiceImpl extends ServiceImpl<YuyuejieyueDao, YuyuejieyueEntity> implements YuyuejieyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyuejieyueEntity> page = this.selectPage(
                new Query<YuyuejieyueEntity>(params).getPage(),
                new EntityWrapper<YuyuejieyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyuejieyueEntity> wrapper) {
		  Page<YuyuejieyueView> page =new Query<YuyuejieyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YuyuejieyueVO> selectListVO(Wrapper<YuyuejieyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuyuejieyueVO selectVO(Wrapper<YuyuejieyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuyuejieyueView> selectListView(Wrapper<YuyuejieyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyuejieyueView selectView(Wrapper<YuyuejieyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
