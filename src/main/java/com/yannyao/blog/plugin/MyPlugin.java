package com.yannyao.blog.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

public class MyPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> list) {
        return true;
    }
    @Override
    public boolean clientGenerated(Interface interfaze,
                                   TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType("BaseMapper<"
                + introspectedTable.getBaseRecordType() + ","
                + introspectedTable.getExampleType()+">");
        FullyQualifiedJavaType imp = new FullyQualifiedJavaType(
                "com.yannyao.blog.mapper.BaseMapper");
        /**
         * 添加 extends
         */
        interfaze.addSuperInterface(fqjt);

        /**
         * 添加import
         */
        interfaze.addImportedType(imp);
        /**
         * 方法不需要
         */
        interfaze.getMethods().clear();
        interfaze.getAnnotations().clear();
        return true;
    }

}
