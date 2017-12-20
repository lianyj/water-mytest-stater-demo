/**************************************************************************
 * Copyright (c) 2016-2017 Zhejiang TaChao Network Technology Co.,Ltd.
 * All rights reserved.
 *
 * 项目名称：浙江踏潮-基础架构
 * 版权说明：本软件属浙江踏潮网络科技有限公司所有，在未获得浙江踏潮网络科技有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.zjtachao.fish.water.watermyteststaterdemo.service;

import com.zjtachao.fish.water.watermyteststaterdemo.bean.TestPerson;

import java.util.List;

public interface TestPersonService {

    /**
     * 查询单条数据
     * @param id
     * @return
     */
     TestPerson queryOneById(Long id);

    /**
     * 查询列表数据
     * @return
     */
     List<TestPerson> queryAll();


    /**
     * 新增数据
     * @param demoPerson
     */
     void insertPerson(TestPerson demoPerson);


    /**
     * 修改数据
     * @param demoPerson
     */
     void updatePersonById(TestPerson demoPerson);

    /**
     * 删除数据
     * @param id
     */
     void deletePersonById(Long id);
}
