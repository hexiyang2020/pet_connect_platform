package com.ruoyi.web.controller.hxy.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.hxy.domain.PetCategory;
import com.ruoyi.web.controller.hxy.service.IPetCategoryService;
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
 * 宠物分类Controller
 * 
 * @author hxy
 * @date 2024-03-07
 */
@RestController
@RequestMapping("/system/category")
public class PetCategoryController extends BaseController
{
    @Autowired
    private IPetCategoryService petCategoryService;

    /*
    * 获取所有分类信息
    * @return 所有分类信息
    */
    @PostMapping(value = "listAll")
    public AjaxResult listAll() {
        List<PetCategory> dataList = petCategoryService.selectPetCategoryList(null);
        return AjaxResult.success(dataList);
    }

    /**
     * 查询宠物分类列表
     */
    @PreAuthorize("@ss.hasPermi('system:category:list')")
    @GetMapping("/list")
    public TableDataInfo list(PetCategory petCategory)
    {
        startPage();
        List<PetCategory> list = petCategoryService.selectPetCategoryList(petCategory);
        return getDataTable(list);
    }

    /**
     * 导出宠物分类列表
     */
    @PreAuthorize("@ss.hasPermi('system:category:export')")
    @Log(title = "宠物分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PetCategory petCategory)
    {
        List<PetCategory> list = petCategoryService.selectPetCategoryList(petCategory);
        ExcelUtil<PetCategory> util = new ExcelUtil<PetCategory>(PetCategory.class);
        util.exportExcel(response, list, "宠物分类数据");
    }

    /**
     * 获取宠物分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:category:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(petCategoryService.selectPetCategoryById(id));
    }

    /**
     * 新增宠物分类
     */
    @PreAuthorize("@ss.hasPermi('system:category:add')")
    @Log(title = "宠物分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PetCategory petCategory)
    {
        return toAjax(petCategoryService.insertPetCategory(petCategory));
    }

    /**
     * 修改宠物分类
     */
    @PreAuthorize("@ss.hasPermi('system:category:edit')")
    @Log(title = "宠物分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PetCategory petCategory)
    {
        return toAjax(petCategoryService.updatePetCategory(petCategory));
    }

    /**
     * 删除宠物分类
     */
    @PreAuthorize("@ss.hasPermi('system:category:remove')")
    @Log(title = "宠物分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(petCategoryService.deletePetCategoryByIds(ids));
    }
}
