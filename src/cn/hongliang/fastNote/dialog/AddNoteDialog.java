package cn.hongliang.fastNote.dialog;

import cn.hongliang.fastNote.data.DataCenter;
import cn.hongliang.fastNote.data.DataConvert;
import cn.hongliang.fastNote.data.NoteData;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * @author Hongliang Zhu
 * @create 2020-07-22 18:51
 */
public class AddNoteDialog extends DialogWrapper {

    private EditorTextField noteTitle;
    private EditorTextField noteContent;

    public AddNoteDialog() {
        super(true);
        setTitle("添加笔记注释");
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        noteTitle = new EditorTextField("笔记标题");
        noteContent = new EditorTextField("笔记内容");
        noteContent.setPreferredSize(new Dimension(200, 100));
        panel.add(noteTitle, BorderLayout.NORTH);
        panel.add(noteContent, BorderLayout.CENTER);
        return panel;
    }

    @Override
    protected JComponent createSouthPanel() {
        JPanel panel = new JPanel();
        JButton button = new JButton("添加笔记到列表");
        button.addActionListener(e -> {
            String noteTitleText = noteTitle.getText();
            String noteContentText = noteContent.getText();
            String fileType = DataCenter.FILE_NAME.substring(DataCenter.FILE_NAME.lastIndexOf(".") + 1);
            NoteData noteData = new NoteData(noteTitleText, noteContentText, DataCenter.SELECTED_TEXT, DataCenter.FILE_NAME, fileType);
            DataCenter.NOTE_LIST.add(noteData);
            DataCenter.TABLEMODEL.addRow(DataConvert.convert(noteData));

            MessageDialogBuilder.YesNo yesNo = MessageDialogBuilder.yesNo("操作结果", "添加成功");
            yesNo.show();
            AddNoteDialog.this.dispose();

        });
        panel.add(button);
        return panel;

    }
}
