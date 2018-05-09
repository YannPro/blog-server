package com.yannyao.blog.service.search;


import io.swagger.models.auth.In;

/**
 * 检索接口
 */
public interface SearchService {

    /**
     * 索引目标文章
     * @param id
     */
//    boolean index(long id);
    void index(long id);

    /**
     * 移除文章索引
     * @param id
     */
    void remove(Integer id);

//    /**
//     * 查询文章接口
//     * @param infoSearch
//     * @return
//     */
//    ServiceMultiResult<Long> query(InfoSearch infoSearch);

    boolean indexPro(Integer id);

//    /**
//     * 多条件匹配
//     * @param infoSearch
//     * @return
//     */
//    public ServiceMultiResult<Information> queryMultiMatch(InfoSearch infoSearch);

}