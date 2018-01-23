import axios from 'axios';

export const requestLogin = params => { return axios.post(`/login`, params).then(res => res.data); };

export const getUserList = params => { return axios.get(`/user/list`, { params: params }); };

export const getUserListPage = params => { return axios.get(`/user/listpage`, { params: params }); };

export const removeUser = params => { return axios.get(`/user/remove`, { params: params }); };

export const editUser = params => { return axios.get(`/user/edit`, { params: params }); };

export const addUser = params => { return axios.get(`/user/add`, { params: params }); };

/* article */
export const getAllArticle = params => { return axios.get(`/admin/article/all`, { params: params }).then(res => res.data); };
//文章列表 有分页
export const getArticleList = params => { return axios.get(`/admin/article`, { params: params }).then(res => res.data); };

export const getArticleById = params => { return axios.get(`/admin/article/${params.id}`, { params: params }).then(res => res.data); };

export const addArticle = params => { return axios.post(`/admin/article`, params).then(res => res.data); };

export const updateArticle = params => { return axios.put(`/admin/article/${params.id}`, { params: params }).then(res => res.data); };

export const deleteArticle = params => { return axios.delete(`/admin/article/${params.id}`, { params: params }).then(res => res.data); };


/* class类目 */
export const getAllClass = params => { return axios.get(`/admin/class/all`, { params: params }).then(res => res.data); };

export const addClass = params => { return axios.post(`/admin/class`, params).then(res => res.data); };

export const deleteClass = params => { return axios.delete(`/admin/class/${params.id}`, { params: params }).then(res => res.data); };


/* tag */
export const getAllTag = params => { return axios.get(`/admin/tag/all`,{ params: params }).then(res => res.data); };

export const addTag = params => { return axios.post(`/admin/tag`, params).then(res => res.data); };

export const deleteTag = params => { return axios.delete(`/admin/tag/${params.id}`, { params: params }).then(res => res.data); };

/* link */
export const getAllLink = params => { return axios.get(`/admin/link/all`, { params: params }).then(res => res.data); };

export const addLink = params => { return axios.post(`/admin/link`, params).then(res => res.data); };

export const deleteLink = params => { return axios.delete(`/admin/link/${params.id}`, { params: params }).then(res => res.data); };

/* comment */
export const getCommentList = params => { return axios.get(`/admin/comment/all`, { params: params }).then(res => res.data); };

export const deleteComment = params => { return axios.delete(`/admin/comment/${params.id}`, { params: params }).then(res => res.data); };
