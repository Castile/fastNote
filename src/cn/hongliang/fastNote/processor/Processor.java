package cn.hongliang.fastNote.processor;

import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * @author Hongliang Zhu
 * @create 2020-07-23 8:50
 *
 * 模板设计模式  模板+数据+where
 */
public interface Processor {
    void process(SourceNoteData sourceNoteData) throws IOException, TemplateException, Exception;
}
