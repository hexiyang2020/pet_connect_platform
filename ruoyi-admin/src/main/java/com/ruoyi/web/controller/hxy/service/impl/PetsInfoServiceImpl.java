package com.ruoyi.web.controller.hxy.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.controller.hxy.domain.PetsInfo;
import com.ruoyi.web.controller.hxy.mapper.PetsInfoMapper;
import com.ruoyi.web.controller.hxy.service.IPetsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 宠物信息Service业务层处理
 * 
 * @author hxy
 * @date 2024-03-08
 */
@Service
public class PetsInfoServiceImpl implements IPetsInfoService
{
    @Autowired
    private PetsInfoMapper petsInfoMapper;

    /**
     * 查询宠物信息
     * 
     * @param id 宠物信息主键
     * @return 宠物信息
     */
    @Override
    public PetsInfo selectPetsInfoById(Long id)
    {
        return petsInfoMapper.selectPetsInfoById(id);
    }

    /**
     * 查询宠物信息列表
     * 
     * @param petsInfo 宠物信息
     * @return 宠物信息
     */
    @Override
    public List<PetsInfo> selectPetsInfoList(PetsInfo petsInfo)
    {
        return petsInfoMapper.selectPetsInfoList(petsInfo);
    }

    /**
     * 新增宠物信息
     * 
     * @param petsInfo 宠物信息
     * @return 结果
     */
    @Override
    public int insertPetsInfo(PetsInfo petsInfo)
    {
        petsInfo.setCreateTime(DateUtils.getNowDate());
        String username = SecurityUtils.getUsername();
        if(StringUtils.isBlank(username)) {
            throw new RuntimeException("用户不存在");
        }
        petsInfo.setCreateBy(username);
        return petsInfoMapper.insertPetsInfo(petsInfo);
    }

    /**
     * 修改宠物信息
     * 
     * @param petsInfo 宠物信息
     * @return 结果
     */
    @Override
    public int updatePetsInfo(PetsInfo petsInfo)
    {
        petsInfo.setUpdateTime(DateUtils.getNowDate());
        String username = SecurityUtils.getUsername();
        if(StringUtils.isBlank(username)) {
            throw new RuntimeException("用户不存在");
        }
        petsInfo.setUpdateBy(username);
        return petsInfoMapper.updatePetsInfo(petsInfo);
    }

    /**
     * 批量删除宠物信息
     * 
     * @param ids 需要删除的宠物信息主键
     * @return 结果
     */
    @Override
    public int deletePetsInfoByIds(Long[] ids)
    {
        return petsInfoMapper.deletePetsInfoByIds(ids);
    }

    /**
     * 删除宠物信息信息
     * 
     * @param id 宠物信息主键
     * @return 结果
     */
    @Override
    public int deletePetsInfoById(Long id)
    {
        return petsInfoMapper.deletePetsInfoById(id);
    }
}
