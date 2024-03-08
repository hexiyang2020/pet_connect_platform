package com.ruoyi.web.controller.hxy.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.controller.hxy.domain.PetCategory;
import com.ruoyi.web.controller.hxy.mapper.PetCategoryMapper;
import com.ruoyi.web.controller.hxy.service.IPetCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 宠物分类Service业务层处理
 * 
 * @author hxy
 * @date 2024-03-07
 */
@Service
public class PetCategoryServiceImpl implements IPetCategoryService
{
    @Autowired
    private PetCategoryMapper petCategoryMapper;

    /**
     * 查询宠物分类
     * 
     * @param id 宠物分类主键
     * @return 宠物分类
     */
    @Override
    public PetCategory selectPetCategoryById(Long id)
    {
        return petCategoryMapper.selectPetCategoryById(id);
    }

    /**
     * 查询宠物分类列表
     * 
     * @param petCategory 宠物分类
     * @return 宠物分类
     */
    @Override
    public List<PetCategory> selectPetCategoryList(PetCategory petCategory)
    {
        return petCategoryMapper.selectPetCategoryList(petCategory);
    }

    /**
     * 新增宠物分类
     * 
     * @param petCategory 宠物分类
     * @return 结果
     */
    @Override
    public int insertPetCategory(PetCategory petCategory)
    {
        petCategory.setCreateTime(DateUtils.getNowDate());
        return petCategoryMapper.insertPetCategory(petCategory);
    }

    /**
     * 修改宠物分类
     * 
     * @param petCategory 宠物分类
     * @return 结果
     */
    @Override
    public int updatePetCategory(PetCategory petCategory)
    {
        petCategory.setUpdateTime(DateUtils.getNowDate());
        return petCategoryMapper.updatePetCategory(petCategory);
    }

    /**
     * 批量删除宠物分类
     * 
     * @param ids 需要删除的宠物分类主键
     * @return 结果
     */
    @Override
    public int deletePetCategoryByIds(Long[] ids)
    {
        return petCategoryMapper.deletePetCategoryByIds(ids);
    }

    /**
     * 删除宠物分类信息
     * 
     * @param id 宠物分类主键
     * @return 结果
     */
    @Override
    public int deletePetCategoryById(Long id)
    {
        return petCategoryMapper.deletePetCategoryById(id);
    }
}
