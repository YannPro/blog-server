//package com.yannyao.blog.service.Impl;
//
//import com.yannyao.blog.bean.City;
//import com.yannyao.blog.service.CityESService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.data.domain.Page;
//import org.springframework.data.elasticsearch.core.query.SearchQuery;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CityESServiceImpl implements CityESService {
//    private static final Logger LOGGER = LoggerFactory.getLogger(CityESServiceImpl.class);
//
//    /* 分页参数 */
//    Integer PAGE_SIZE = 12;          // 每页数量
//    Integer DEFAULT_PAGE_NUMBER = 0; // 默认当前页码
//
//    /* 搜索模式 */
//    String SCORE_MODE_SUM = "sum"; // 权重分求和模式
//    Float  MIN_SCORE = 10.0F;      // 由于无相关性的分值默认为 1 ，设置权重分最小值为 10
//    public List<City> searchCity(String searchContent) {
//
//        LOGGER.info("\n searchCity: searchContent [" + searchContent + "] \n ");
//
//        // 构建搜索查询
////        SearchQuery searchQuery = getCitySearchQuery(searchContent);
//
////        LOGGER.info("\n searchCity: searchContent [" + searchContent + "] \n DSL  = \n " + searchQuery.getQuery().toString());
//
////        Page<City> cityPage = cityRepository.search(searchQuery);
////        return cityPage.getContent();
//        return null;
//    }
//}
