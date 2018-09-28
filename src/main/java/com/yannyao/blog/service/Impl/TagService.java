package com.yannyao.blog.service.Impl;

import com.yannyao.blog.bean.Tag;
import com.yannyao.blog.bean.TagExample;
import com.yannyao.blog.common.module.dto.TagDTO;
import com.yannyao.blog.common.request.AddTagRequest;
import com.yannyao.blog.common.response.BaseResponse;
import com.yannyao.blog.mapper.BaseMapper;
import com.yannyao.blog.mapper.TagMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: YannYao
 * @Description:
 * @Date Created in 13:44 2017/12/11
 */
@Component
public class TagService extends BaseService<Tag, TagExample>{

    @Autowired
    private TagMapper tagMapper;

    @Override
    BaseMapper<Tag, TagExample> mapper() {
        return tagMapper;
    }

    public BaseResponse<List<Tag>> listTag () {
        BaseResponse<List<Tag>> response = new BaseResponse<>();
        List<Tag> tagList = listByExample(new TagExample(), 1, 1000);
        return response.setData(tagList);
    }

    @Transactional
    public BaseResponse addTag (AddTagRequest request) {
        List<TagDTO> tagDTOList = request.getTagList();
        tagDTOList.forEach(tagDTO -> {
            Tag tag = new Tag();
            BeanUtils.copyProperties(tagDTO, tag);
            mapper().insertSelective(tag);
        });
        return new BaseResponse();
    }

    @Transactional
    public BaseResponse deleteTag (Integer id) {
        mapper().deleteByPrimaryKey(id);
        return new BaseResponse();
    }
}
