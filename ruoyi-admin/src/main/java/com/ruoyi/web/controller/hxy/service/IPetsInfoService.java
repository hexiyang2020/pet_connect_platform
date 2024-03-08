package com.ruoyi.web.controller.hxy.service;

import com.ruoyi.web.controller.hxy.domain.PetsInfo;

import java.util.List;

/**
 * 宠物信息Service接口
 * 
 * @author hxy
 * @date 2024-03-08
 */
public interface IPetsInfoService 
{
    /**
     * 查询宠物信息
     * 
     * @param id 宠物信息主键
     * @return 宠物信息
     */
    public PetsInfo selectPetsInfoById(Long id);

    /**
     * 查询宠物信息列表
     * 
     * @param petsInfo 宠物信息
     * @return 宠物信息集合
     */
    public List<PetsInfo> selectPetsInfoList(PetsInfo petsInfo);

    /**
     * 新增宠物信息
     * 
     * @param petsInfo 宠物信息
     * @return 结果
     */
    public int insertPetsInfo(PetsInfo petsInfo);

    /**
     * 修改宠物信息
     * 
     * @param petsInfo 宠物信息
     * @return 结果
     */
    public int updatePetsInfo(PetsInfo petsInfo);

    /**
     * 批量删除宠物信息
     * 
     * @param ids 需要删除的宠物信息主键集合
     * @return 结果
     */
    public int deletePetsInfoByIds(Long[] ids);

    /**
     * 删除宠物信息信息
     * 
     * @param id 宠物信息主键
     * @return 结果
     */
    public int deletePetsInfoById(Long id);
}
