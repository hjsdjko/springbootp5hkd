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


import com.dao.YuyueguihaiDao;
import com.entity.YuyueguihaiEntity;
import com.service.YuyueguihaiService;
import com.entity.vo.YuyueguihaiVO;
import com.entity.view.YuyueguihaiView;

@Service("yuyueguihaiService")
public class YuyueguihaiServiceImpl extends ServiceImpl<YuyueguihaiDao, YuyueguihaiEntity> implements YuyueguihaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyueguihaiEntity> page = this.selectPage(
                new Query<YuyueguihaiEntity>(params).getPage(),
                new EntityWrapper<YuyueguihaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyueguihaiEntity> wrapper) {
		  Page<YuyueguihaiView> page =new Query<YuyueguihaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YuyueguihaiVO> selectListVO(Wrapper<YuyueguihaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuyueguihaiVO selectVO(Wrapper<YuyueguihaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuyueguihaiView> selectListView(Wrapper<YuyueguihaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyueguihaiView selectView(Wrapper<YuyueguihaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
