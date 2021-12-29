package com.fantasi.xxd.controller;

import com.fantasi.xxd.elasticsearch.UserES;
//import com.fantasi.xxd.elasticsearch.UserESRepository;
import com.fantasi.xxd.entity.User;
import com.fantasi.xxd.service.UserService;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.*;

/**
 * @author xxd
 * @date 2019/12/16 11:10
 */
@RestController
@RequestMapping("/xxd/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private UserESRepository userESRepository;

    @GetMapping("/searchAll")
    public Object searchAll(@RequestParam( name = "pageNum", required = false, defaultValue = "1") int pageNum,
                            @RequestParam( name = "pageSize", required = false,defaultValue = "10") int pageSize){
        return userService.findAllUser(pageNum, pageSize);
    }

    @PostMapping("add")
    public int addUser(User user){
        return userService.addUser(user);
    }

    /*-------------------- ES查询 ----------------------------*/

//    @GetMapping("create")
//    public String create(
//            @RequestParam("id") Long id,
//            @RequestParam("userName") String userName,
//            @RequestParam("phone") String phone){
//        UserES userES = new UserES();
//        userES.setId(id);
//        userES.setPhone(phone);
//        userES.setUserName(userName);
//        return userESRepository.save(userES).toString();
//    }
//
//    private String names;
//
//    @GetMapping("get")
//    public String get(){
//        names = "";
//        Iterable<UserES> userES = userESRepository.findAll();
//        userES.forEach(userES1 ->
//            names += userES1.toString() + "\n"
//        );
//        return names;
//    }
//
//    private String searchs = "";
//
//    @GetMapping("search")
//    public String search(@RequestParam("searchKey") String searchKey){
//        searchs = "";
//        //构建查询条件
//        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
//        //添加基本分词查询
//        queryBuilder.withQuery(QueryBuilders.matchQuery("userName",searchKey));
//        //打印 查询语句
//        System.out.println(queryBuilder.build().getQuery().toString());
//        //搜索 获取结果
//        Page<UserES> items = userESRepository.search(queryBuilder.build());
//        //总条数
//        long total = items.getTotalElements();
//        searchs += "总共数据数:"+ total + "\n";
//        items.forEach(userES -> {
//            searchs += userES.toString() + "\n";
//        });
//        return searchs;
//    }
}
