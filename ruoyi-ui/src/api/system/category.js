import request from '@/utils/request'
//查询所有宠物分类
export function listAllCategory() {
  return request({
    url: '/system/category/listAll',
    method: 'POST',
  })
}

// 查询宠物分类列表
export function listCategory(query) {
  return request({
    url: '/system/category/list',
    method: 'get',
    params: query
  })
}

// 查询宠物分类详细
export function getCategory(id) {
  return request({
    url: '/system/category/' + id,
    method: 'get'
  })
}

// 新增宠物分类
export function addCategory(data) {
  return request({
    url: '/system/category',
    method: 'post',
    data: data
  })
}

// 修改宠物分类
export function updateCategory(data) {
  return request({
    url: '/system/category',
    method: 'put',
    data: data
  })
}

// 删除宠物分类
export function delCategory(id) {
  return request({
    url: '/system/category/' + id,
    method: 'delete'
  })
}
