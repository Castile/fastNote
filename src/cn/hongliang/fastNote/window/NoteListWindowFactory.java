package cn.hongliang.fastNote.window;

import b.e.P;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import static com.intellij.ui.content.ContentFactory.SERVICE.getInstance;

/**
 *
 *工厂类  工具视窗
 * @author Hongliang Zhu
 * @create 2020-07-22 23:09
 */
public class NoteListWindowFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        // 创建NoteListWindow对象
        NoteListWindow noteListWindow = new NoteListWindow(project, toolWindow);
        // 获取内容工厂的实例
        ContentFactory contentFactory = getInstance();
        // 获取用于ToolWindow显示的内容
        Content content = contentFactory.createContent(noteListWindow.getContentPanel(), "", false);
        //给toolWindow设置内容
        toolWindow.getContentManager().addContent(content);
    }
}
