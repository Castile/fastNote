package cn.hongliang.fastNote.processor;

import cn.hongliang.fastNote.data.NoteData;

import java.util.List;

/**
 *
 * 描述笔记的数据
 * @author Hongliang Zhu
 * @create 2020-07-23 8:50
 */
public interface SourceNoteData {
    /**
     * 获取笔记的文件名
     * @return
     */
    String getFileName();

    /**
     * 获取文档的标题
     * @return
     */
    String getTopic();

    /**
     * 获取笔记
     * @return
     */
    List<NoteData> getNoteList();



}
