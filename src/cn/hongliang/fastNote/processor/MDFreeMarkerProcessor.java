package cn.hongliang.fastNote.processor;
import com.intellij.ide.fileTemplates.impl.UrlUtil;
import com.intellij.util.io.URLUtil;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hongliang Zhu
 * @create 2020-07-23 9:14
 */
public class MDFreeMarkerProcessor extends AbstractFreeMarkerProcessor {
    @Override
    protected Object getModel(SourceNoteData sourceNoteData) {
        Map model = new HashMap();
        model.put("topic", sourceNoteData.getTopic());
        model.put("noteList", sourceNoteData.getNoteList());
        return model;

    }

    @Override
    protected Template getTemplate() throws Exception {

        // 创建模板配置
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);

        // 加载模板字符串
        String templateContent = UrlUtil.loadText(MDFreeMarkerProcessor.class.getResource("/template/md.ftl"));
        // 创建字符串模板导入器
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        // 导入字符串模板
        stringTemplateLoader.putTemplate("MDtemplate", templateContent);
        configuration.setTemplateLoader(stringTemplateLoader);

        // 获取模板
        return configuration.getTemplate("MDtemplate");
    }

    @Override
    protected Writer getWriter(SourceNoteData sourceNoteData) throws Exception {
        String fileName = sourceNoteData.getFileName();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName)), "utf-8"));
        return bufferedWriter;
    }
}
