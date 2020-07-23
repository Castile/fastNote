package cn.hongliang.fastNote.processor;

import freemarker.template.Template;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;

/**
 * 使用FreeMarker生成
 * @author Hongliang Zhu
 * @create 2020-07-23 8:54
 *
 * 模板设计模式
 */
public abstract class AbstractFreeMarkerProcessor implements Processor{

    /**
     * 处理流程
     * @return
     */
    protected abstract Object getModel(SourceNoteData sourceNoteData); // 获取数据

    protected abstract Template getTemplate() throws IOException, Exception;  // 获取模板

    protected abstract Writer getWriter(SourceNoteData sourceNoteData) throws FileNotFoundException, Exception; // 写到哪里


    /**
     * 子类实现上面三个方法，按照这个方法的流程进行（模板）
     * @param sourceNoteData
     * @throws Exception
     */
    @Override
    public final void process(SourceNoteData sourceNoteData) throws Exception {
        Template template = getTemplate();
        Object model = getModel(sourceNoteData);
        Writer writer = getWriter(sourceNoteData);
        template.process(model, writer);
    }
}
