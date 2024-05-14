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


import com.dao.WenxintishiDao;
import com.entity.WenxintishiEntity;
import com.service.WenxintishiService;
import com.entity.vo.WenxintishiVO;
import com.entity.view.WenxintishiView;

@Service("wenxintishiService")
public class WenxintishiServiceImpl extends ServiceImpl<WenxintishiDao, WenxintishiEntity> implements WenxintishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WenxintishiEntity> page = this.selectPage(
                new Query<WenxintishiEntity>(params).getPage(),
                new EntityWrapper<WenxintishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WenxintishiEntity> wrapper) {
		  Page<WenxintishiView> page =new Query<WenxintishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WenxintishiVO> selectListVO(Wrapper<WenxintishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WenxintishiVO selectVO(Wrapper<WenxintishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WenxintishiView> selectListView(Wrapper<WenxintishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WenxintishiView selectView(Wrapper<WenxintishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
