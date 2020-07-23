package cn.hongliang.fastNote.action;

import cn.hongliang.fastNote.data.DataCenter;
import cn.hongliang.fastNote.dialog.AddNoteDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

/**
 * @author Hongliang Zhu
 * @create 2020-07-22 18:39
 */
public class PopUpAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // 首先获取编辑器对象
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        // 获取选择的文本
        SelectionModel selectionModel = editor.getSelectionModel();
        String selectedText = selectionModel.getSelectedText();
        DataCenter.SELECTED_TEXT = selectedText;

        // 獲取文件的名稱
        String fileName = e.getRequiredData(CommonDataKeys.PSI_FILE).getVirtualFile().getName();
        DataCenter.FILE_NAME = fileName;

        AddNoteDialog addNoteDialog = new AddNoteDialog();
        addNoteDialog.show();

//        System.out.println(selectedText);

    }
}
