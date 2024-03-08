package com.ruoyi.web.controller.hxy.service;

import java.util.List;
import com.ruoyi.web.controller.hxy.domain.PetCategory;

/**
 * 宠物分类Service接口
 * 
 * @author hxy
 * @date 2024-03-07
 */
public interface IPetCategoryService 
{
    /**
     * 查询宠物分类
     * 
     * @param id 宠物分类主键
     * @return 宠物分类
     */
    public PetCategory selectPetCategoryById(Long id);

    /**
     * 查询宠物分类列表
     * 
     * @param petCategory 宠物分类
     * @return 宠物分类集合
     */
    public List<PetCategory> selectPetCategoryList(PetCategory petCategory);

    /**
     * 新增宠物分类
     * 
     * @param petCategory 宠物分类
     * @return 结果
     */
    public int insertPetCategory(PetCategory petCategory);

    /**
     * 修改宠物分类
     * 
     * @param petCategory 宠物分类
     * @return 结果
     */
    public int updatePetCategory(PetCategory petCategory);

    /**
     * 批量删除宠物分类
     * 
     * @param ids 需要删除的宠物分类主键集合
     * @return 结果
     */
    public int deletePetCategoryByIds(Long[] ids);

    /**
     * 删除宠物分类信息
     * 
     * @param id 宠物分类主键
     * @return 结果
     */
    public int deletePetCategoryById(Long id);
}
