package cn.hongliang.fastNote.window;
import cn.hongliang.fastNote.data.DataCenter;
import cn.hongliang.fastNote.processor.DefaultSourceNoteData;
import cn.hongliang.fastNote.processor.MDFreeMarkerProcessor;
import cn.hongliang.fastNote.processor.Processor;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Hongliang Zhu
 * @create 2020-07-22 22:52
 */
public class NoteListWindow {
    /**
     * main panel
     */
    private JPanel contentPanel;
    /**
     * 文档标题
     */
    private JTextField tfTopic;

    /**
     * 三个按钮
     */
    private JButton btnCreate;
    private JButton btnClear;
    private JButton btnClose;
    private JTable tabContent;

    private void init(){
        tabContent.setModel(DataCenter.TABLEMODEL);
        tabContent.setEnabled(true);
    }

    public NoteListWindow(Project project, ToolWindow toolWindow) {
        init();

        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String topic = tfTopic.getText();
                String fileName = topic+".md";
                if(topic == null || "".equals(topic)){
                    MessageDialogBuilder.YesNo yesNo = MessageDialogBuilder.yesNo("操作结果", "请输入文档名");
                    yesNo.show();
                    return;
                }
                // 选择文件夹
                VirtualFile virtualFile = FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFolderDescriptor(), project, project.getBaseDir());
                if(virtualFile != null){
                    // 保存的路径
                    String path = virtualFile.getPath();
                    String fileFullPath = path + "/" + fileName;

                    Processor processor = new MDFreeMarkerProcessor();
                    try {
                        processor.process(new DefaultSourceNoteData(fileFullPath, topic, DataCenter.NOTE_LIST));
                        // 通知
                        NotificationGroup notificationGroup = new NotificationGroup("fastNote_id", NotificationDisplayType.BALLOON, true);
                        Notification notification = notificationGroup.createNotification("生成文档成功：" + fileFullPath, MessageType.INFO);
                        Notifications.Bus.notify(notification);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }


                }


            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataCenter.reset();

            }
        });

        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolWindow.hide(null);
            }
        });
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }


}
