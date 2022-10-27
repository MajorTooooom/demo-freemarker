package com.dororo.future;


import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import cn.hutool.system.SystemUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.*;

public class JustTests {
    //输出到桌面文件夹
    //private static String output = StrUtil.format("{}\\\\{}", FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath(), "output");
    //输出到项目out目录方便查看
    private static String output = StrUtil.format("{}\\\\{}", SystemUtil.getUserInfo().getCurrentDir(), "out");
    //指定目录获取模板引擎
    private static TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("freemarker", TemplateConfig.ResourceMode.CLASSPATH));
    //根据ftl文件目录路径获取文件列表
    private static List<File> ftlList = ListUtil.toList(FileUtil.ls(StrUtil.format("{}{}", SystemUtil.getUserInfo().getCurrentDir(), "src\\main\\resources\\freemarker")));

    @Test
    void test01() {
        ftlList.forEach(file -> {
            //传参
            HashMap<String, Object> bindingMap = new HashMap<>();
            bindingMap.put("testBoolean01", true);//测试布尔值
            bindingMap.put("testBoolean02", false);//测试布尔值

            bindingMap.put("datetime", new Date());//测试日期

            bindingMap.put("number01", 12.34);//测试数值类型
            bindingMap.put("number02", 0.56);//测试数值类型

            bindingMap.put("strValue", "Aa_Bb_Cc_Dd");//测试字符串

            // 序列类型 （数组、List、Set）
            // 数组操作
            String[] stars = new String[]{"周杰伦", "林俊杰", "陈奕迅", "五月天"};
            bindingMap.put("stars", stars);
            // List操作
            List<String> citys = Arrays.asList("上海", "北京", "杭州", "深圳");
            bindingMap.put("cityList", citys);
            // JavaBean集合
            List<User> userList = new ArrayList<>();
            userList.add(new User(1, "zhangsan", 22));
            userList.add(new User(2, "lisi", 18));
            userList.add(new User(3, "wangwu", 20));
            bindingMap.put("userList", userList);

            String ftlName = FileUtil.getName(file);
            Template template = engine.getTemplate(ftlName);
            String target = output + "\\" + ftlName.replace(".ftl", "");
            //执行渲染
            template.render(bindingMap, FileUtil.file(target));
        });
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class User {
        private int id;
        private String name;
        private int age;
    }
}
