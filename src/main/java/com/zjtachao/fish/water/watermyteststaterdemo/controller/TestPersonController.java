/**************************************************************************
 * Copyright (c) 2016-2017 Zhejiang TaChao Network Technology Co.,Ltd.
 * All rights reserved.
 *
 * 项目名称：浙江踏潮-基础架构
 * 版权说明：本软件属浙江踏潮网络科技有限公司所有，在未获得浙江踏潮网络科技有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.zjtachao.fish.water.watermyteststaterdemo.controller;

import com.alibaba.fastjson.JSON;
import com.zjtachao.fish.water.common.base.bean.WaterBootResultBean;
import com.zjtachao.fish.water.common.base.context.WaterBootResultContext;
import com.zjtachao.fish.water.common.base.controller.WaterBootBaseController;
import com.zjtachao.fish.water.watermyteststaterdemo.bean.TestPerson;
import com.zjtachao.fish.water.watermyteststaterdemo.service.TestPersonService;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

@Path("/test/person")
public class TestPersonController extends  WaterBootBaseController{

    @Autowired
    private TestPersonService personService;

    /**
     * 查询所有
     */
    @GET
    @Path("/queryall")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public WaterBootResultBean<TestPerson> queryAll(){
        WaterBootResultBean<TestPerson> result = new WaterBootResultBean<TestPerson>();
        result.setCode(WaterBootResultContext.ResultCode.VALID_NO_PASS.getCode());
        try {
            List<TestPerson> list = personService.queryAll();
            result.setCode(WaterBootResultContext.ResultCode.SUCCESS.getCode());
            result.setMsg("查询成功！");
            result.setRst(list);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            result.setCode(WaterBootResultContext.ResultCode.ERROR.getCode());
            result.setMsg("服务器出错！");
        }
        return result;
    }

    /**
     * 查询单条
     */
    @GET
    @Path("/queryone/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public WaterBootResultBean<TestPerson> queryOneById(
            @PathParam("id")Long id
        ){
        WaterBootResultBean<TestPerson> result = new WaterBootResultBean<TestPerson>();
        result.setCode(WaterBootResultContext.ResultCode.VALID_NO_PASS.getCode());
        try {
            TestPerson person = personService.queryOneById(id);
            result.setCode(WaterBootResultContext.ResultCode.SUCCESS.getCode());
            result.setMsg("查询成功！");
            result.setRst(person);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            result.setCode(WaterBootResultContext.ResultCode.ERROR.getCode());
            result.setMsg("服务器出错！");
        }
        return result;
    }

    /**
     * 新增数据
     */
    @POST
    @Path("/save")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public WaterBootResultBean<TestPerson> savePerson(
          String jsonStr
    ){
        WaterBootResultBean<TestPerson> result = new WaterBootResultBean<TestPerson>();
        result.setCode(WaterBootResultContext.ResultCode.VALID_NO_PASS.getCode());
        try {
            TestPerson person = JSON.parseObject(jsonStr,TestPerson.class);
            Boolean flag = true;

            if(flag && (null ==person.getName() || "".equals(person.getName()))){
                flag = false;
                result.setMsg("姓名为空！");
            }
            if(flag && (null ==person.getAddress() || "".equals(person.getAddress()))){
                flag = false;
                result.setMsg("地址为空！");
            }
            if(flag && null ==person.getAge()){
                flag = false;
                result.setMsg("年级为空！");
            }
            if(flag){
                Date date = new Date();
                person.setModifyTime(date);
                person.setCreateTime(date);
                person.setDeleteFlag(0);
                personService.insertPerson(person);
                result.setCode(WaterBootResultContext.ResultCode.SUCCESS.getCode());
                result.setMsg("新增成功！");
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            result.setCode(WaterBootResultContext.ResultCode.ERROR.getCode());
            result.setMsg("服务器出错！");
        }
        return result;
    }



    /**
     * 修改数据
     */
    @POST
    @Path("/update")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public WaterBootResultBean<TestPerson> editPerson(
            String jsonStr
    ){
        WaterBootResultBean<TestPerson> result = new WaterBootResultBean<TestPerson>();
        result.setCode(WaterBootResultContext.ResultCode.VALID_NO_PASS.getCode());
        try {
            TestPerson person = JSON.parseObject(jsonStr,TestPerson.class);
            Boolean flag = true;
            if(null ==person.getId() || 0==person.getId()){
                flag = false;
                result.setMsg("id为空！");
            }
            if(flag && (null ==person.getName() || "".equals(person.getName()))){
                flag = false;
                result.setMsg("姓名为空！");
            }
            if(flag && (null ==person.getAddress() || "".equals(person.getAddress()))){
                flag = false;
                result.setMsg("地址为空！");
            }
            if(flag && null ==person.getAge()){
                flag = false;
                result.setMsg("年级为空！");
            }
            if(flag){
                Date date = new Date();
                person.setModifyTime(date);
                person.setDeleteFlag(0);
                personService.updatePersonById(person);
                result.setCode(WaterBootResultContext.ResultCode.SUCCESS.getCode());
                result.setMsg("修改成功！");
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            result.setCode(WaterBootResultContext.ResultCode.ERROR.getCode());
            result.setMsg("服务器出错！");
        }
        return result;
    }

    /**
     * 删除单条
     */
    @GET
    @Path("/delete/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public WaterBootResultBean<TestPerson> deleteOneById(
            @PathParam("id")Long id
    ){
        WaterBootResultBean<TestPerson> result = new WaterBootResultBean<TestPerson>();
        result.setCode(WaterBootResultContext.ResultCode.VALID_NO_PASS.getCode());
        try {
            personService.deletePersonById(id);
            result.setCode(WaterBootResultContext.ResultCode.SUCCESS.getCode());
            result.setMsg("删除成功！");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            result.setCode(WaterBootResultContext.ResultCode.ERROR.getCode());
            result.setMsg("服务器出错！");
        }
        return result;
    }

}
