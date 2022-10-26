package com.dororo.future;


import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import cn.hutool.system.SystemUtil;
import org.junit.jupiter.api.Test;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.List;

public class JustTests {
    /**
     * 输出到桌面文件夹
     */
    private static String output = StrUtil.format("{}\\\\{}", FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath(), "output");
    /**
     * 指定目录获取模板引擎
     */
    private static TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("freemarker", TemplateConfig.ResourceMode.CLASSPATH));

    /**
     * 根据ftl文件目录路径获取文件列表
     */
    private static List<File> ftlList = ListUtil.toList(FileUtil.ls(StrUtil.format("{}{}", SystemUtil.getUserInfo().getCurrentDir(), "src\\main\\resources\\freemarker")));

    @Test
    void test01() {
        ftlList.forEach(file -> {
            String ftlName = FileUtil.getName(file);
            Template template = engine.getTemplate(ftlName);
            String target = output + "\\" + ftlName.replace(".ftl", "");
            template.render(null, FileUtil.file(target));
        });
    }
}
