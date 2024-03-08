package com.ruoyi.web.controller.hxy.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.hxy.domain.PetCategory;
import com.ruoyi.web.controller.hxy.domain.PetsInfo;
import com.ruoyi.web.controller.hxy.service.IPetCategoryService;
import com.ruoyi.web.controller.hxy.service.IPetsInfoService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宠物信息Controller
 * 
 * @author hxy
 * @date 2024-03-08
 */
@RestController
@RequestMapping("/system/petsinfo")
public class PetsInfoController extends BaseController
{
    @Autowired
    private IPetsInfoService petsInfoService;

    @Resource
    private IPetCategoryService iPetCategoryService;

    /**
     * 查询宠物信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:petsinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(PetsInfo petsInfo)
    {
        startPage();
        List<PetsInfo> list = petsInfoService.selectPetsInfoList(petsInfo);
        if(list != null && list.size() > 0) {
            list = list.stream().peek(item ->{
                Long categoryId = item.getCategoryId();
                PetCategory petCategory = iPetCategoryService.selectPetCategoryById(categoryId);
                if(petCategory != null) {
                    item.setCategoryName(petCategory.getCategoryName());
                }
            }).collect(Collectors.toList());
        }
        return getDataTable(list);
    }

    /**
     * 导出宠物信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:petsinfo:export')")
    @Log(title = "宠物信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PetsInfo petsInfo)
    {
        List<PetsInfo> list = petsInfoService.selectPetsInfoList(petsInfo);
        ExcelUtil<PetsInfo> util = new ExcelUtil<PetsInfo>(PetsInfo.class);
        util.exportExcel(response, list, "宠物信息数据");
    }

    /**
     * 获取宠物信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:petsinfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(petsInfoService.selectPetsInfoById(id));
    }

    /**
     * 新增宠物信息
     */
    @PreAuthorize("@ss.hasPermi('system:petsinfo:add')")
    @Log(title = "宠物信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PetsInfo petsInfo)
    {
        return toAjax(petsInfoService.insertPetsInfo(petsInfo));
    }

    /**
     * 修改宠物信息
     */
    @PreAuthorize("@ss.hasPermi('system:petsinfo:edit')")
    @Log(title = "宠物信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PetsInfo petsInfo)
    {
        return toAjax(petsInfoService.updatePetsInfo(petsInfo));
    }

    /**
     * 删除宠物信息
     */
    @PreAuthorize("@ss.hasPermi('system:petsinfo:remove')")
    @Log(title = "宠物信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(petsInfoService.deletePetsInfoByIds(ids));
    }
}
