/**************************************************************************
 * Copyright (c) 2016-2017 Zhejiang TaChao Network Technology Co.,Ltd.
 * All rights reserved.
 *
 * 项目名称：浙江踏潮-基础架构
 * 版权说明：本软件属浙江踏潮网络科技有限公司所有，在未获得浙江踏潮网络科技有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.zjtachao.fish.water.watermyteststaterdemo.service.impl;

import com.zjtachao.fish.water.watermyteststaterdemo.bean.TestPerson;
import com.zjtachao.fish.water.watermyteststaterdemo.mapper.TestPersonMapper;
import com.zjtachao.fish.water.watermyteststaterdemo.service.TestPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("personService")
public class TestPersonServiceImpl implements TestPersonService{


    @Autowired
    private TestPersonMapper testPersonMapper;

    /**
     * 查询单条数据
     * @param id
     * @return
     */
    public TestPerson queryOneById(Long id){
        return testPersonMapper.findById(id);
    }

    /**
     * 查询列表数据
     * @return
     */
    public List<TestPerson> queryAll(){
        return testPersonMapper.findAll();
    }


    /**
     * 新增数据
     * @param demoPerson
     */
    public void insertPerson(TestPerson demoPerson){
        testPersonMapper.insertPerson(demoPerson);
    }


    /**
     * 修改数据
     * @param demoPerson
     */
    public void updatePersonById(TestPerson demoPerson){
        testPersonMapper.updatePersonById(demoPerson);
    }

    /**
     * 删除数据
     * @param id
     */
    public void deletePersonById(Long id){
        testPersonMapper.deletePersonById(id);
    }

}
