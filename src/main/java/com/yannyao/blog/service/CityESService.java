package com.yannyao.blog.service;

import com.yannyao.blog.bean.City;

import java.util.List;

public interface CityESService {
    public List<City> searchCity(String searchContent);
}
