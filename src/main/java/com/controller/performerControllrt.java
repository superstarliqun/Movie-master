package com.controller;

import com.entity.Performer;
import com.service.PerformerService;
import com.util.RestResult;
import com.util.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/performer")
public class performerControllrt {

    @Autowired
    PerformerService performerService;


    /**
     * 新增演员接口
     * @param performer
     * @param request
     * @return
     */
    @PostMapping(value = "addPerformerService")
    public RestResult addPerformerService(Performer performer, HttpServletRequest request){
        if(performer.getFile()!=null){
            performer.setPerformerUrl(UploadUtils.getImgUrl(performer.getFile(),request));
        }
        performerService.insertSelective(performer);
        return RestResult.ok();
    }

    /**
     * 删除演员
     * @param id
     * @return
     */
    @PostMapping(value = "/delPerformer")
    public RestResult delPerformer(Integer id){
        int i = performerService.deleteByPrimaryKey(id);
        if(i>0){
            return RestResult.ok();
        }
        return RestResult.build(500,"删除失败");
    }



}
