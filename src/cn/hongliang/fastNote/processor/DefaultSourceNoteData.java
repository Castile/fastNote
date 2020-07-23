package cn.hongliang.fastNote.processor;

import cn.hongliang.fastNote.data.NoteData;

import java.util.List;

/**
 * @author Hongliang Zhu
 * @create 2020-07-23 9:35
 */
public class DefaultSourceNoteData implements SourceNoteData {

    private String fileName;
    private String topic;
    private List<NoteData> noteDataList;

    public DefaultSourceNoteData(String fileName, String topic, List<NoteData> noteDataList) {
        this.fileName = fileName;
        this.topic = topic;
        this.noteDataList = noteDataList;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public List<NoteData> getNoteList() {
        return noteDataList;
    }
}
