import request from '@/utils/request'

export function userLogin(data){
    return request({
        url: '/login',
        method: 'post',
        data
    })
}
export function userList(data){
    return request({
        url:'/user/list',
        method:'post',
        data
    })
}
export function userAdd(data){
    return request({
        url: '/user/add',
        method: 'post',
        data
    })
}
export function userUpdate(data){
    return request({
        url:'/user/update',
        method:'post',
        data
    })
}
export function userDelete(id){
    return request({
        url:'/user/delete',
        method:'post',
        params:{
            id
        }
    })
}
export function userBatchDelete(data){
    return request({
        url:'/user/delete/batch',
        method:'post',
        data
    })
}