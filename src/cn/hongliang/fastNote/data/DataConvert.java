package cn.hongliang.fastNote.data;

/**
 * @author Hongliang Zhu
 * @create 2020-07-22 23:57
 */
public class DataConvert {
    public static String[] convert(NoteData noteData){
        String[] row = new String[4];
        row[0] = noteData.getTitle();
        row[1] = noteData.getMark();
        row[2] = noteData.getFileName();
        row[3] = noteData.getContent();

        return row;
    }
}
