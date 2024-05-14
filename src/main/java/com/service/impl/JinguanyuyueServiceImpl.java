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


import com.dao.JinguanyuyueDao;
import com.entity.JinguanyuyueEntity;
import com.service.JinguanyuyueService;
import com.entity.vo.JinguanyuyueVO;
import com.entity.view.JinguanyuyueView;

@Service("jinguanyuyueService")
public class JinguanyuyueServiceImpl extends ServiceImpl<JinguanyuyueDao, JinguanyuyueEntity> implements JinguanyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JinguanyuyueEntity> page = this.selectPage(
                new Query<JinguanyuyueEntity>(params).getPage(),
                new EntityWrapper<JinguanyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JinguanyuyueEntity> wrapper) {
		  Page<JinguanyuyueView> page =new Query<JinguanyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JinguanyuyueVO> selectListVO(Wrapper<JinguanyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JinguanyuyueVO selectVO(Wrapper<JinguanyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JinguanyuyueView> selectListView(Wrapper<JinguanyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JinguanyuyueView selectView(Wrapper<JinguanyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
