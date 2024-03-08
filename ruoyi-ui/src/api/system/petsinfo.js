import request from '@/utils/request'

// 查询宠物信息列表
export function listPetsinfo(query) {
  return request({
    url: '/system/petsinfo/list',
    method: 'get',
    params: query
  })
}

// 查询宠物信息详细
export function getPetsinfo(id) {
  return request({
    url: '/system/petsinfo/' + id,
    method: 'get'
  })
}

// 新增宠物信息
export function addPetsinfo(data) {
  return request({
    url: '/system/petsinfo',
    method: 'post',
    data: data
  })
}

// 修改宠物信息
export function updatePetsinfo(data) {
  return request({
    url: '/system/petsinfo',
    method: 'put',
    data: data
  })
}

// 删除宠物信息
export function delPetsinfo(id) {
  return request({
    url: '/system/petsinfo/' + id,
    method: 'delete'
  })
}
