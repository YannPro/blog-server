package com.yannyao.blog.controller.admin;

import com.yannyao.blog.bean.FriendLink;
import com.yannyao.blog.common.request.AddFriendLinkRequest;
import com.yannyao.blog.common.response.BaseResponse;
import com.yannyao.blog.service.Impl.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin/friendLink")
public class FriendLinkController {

    @Autowired
    private FriendLinkService friendLinkService;

    @GetMapping("/all")
    @ResponseBody
    public BaseResponse<List<FriendLink>> getList(){
        return friendLinkService.listFriendLink();
    }

    @PostMapping
    @ResponseBody
    public BaseResponse addFriendLink(@Valid AddFriendLinkRequest request){
        return friendLinkService.addFriendLink(request);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public BaseResponse delete(@PathVariable(value = "id") Integer id){
        return friendLinkService.deleteFriendLink(id);
    }
    
}
