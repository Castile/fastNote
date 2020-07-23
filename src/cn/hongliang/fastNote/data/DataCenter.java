package cn.hongliang.fastNote.data;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hongliang Zhu
 * @create 2020-07-22 20:13
 */
public class DataCenter {

    public static String SELECTED_TEXT;
    public static String FILE_NAME;
    public static List<NoteData> NOTE_LIST = new LinkedList<>();

    public static String[] TABLE_HEADER = {"标题", "备注", "文件名", "代码段"};

    public static DefaultTableModel TABLEMODEL = new DefaultTableModel(null, TABLE_HEADER);

    /***
     * 清空数据
     */
    public static void reset(){
        NOTE_LIST.clear();
        TABLEMODEL.setDataVector(null, TABLE_HEADER);
    }


}

