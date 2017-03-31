package deployProcess;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.task.Task;
import org.junit.Test;
/**
 * 获取待办任务（我的正在执行的任务）
 * @author Wen
 *
 */
public class getMyTask {
	
	//获取工作流引擎
	ProcessEngine c_ProcessEngine=ProcessEngines.getDefaultProcessEngine();
@Test
public void getMyTask(){
	//办理人名称 
	String m_Assignee="李四";
	Task m_task=c_ProcessEngine.getTaskService().createTaskQuery().taskAssignee(m_Assignee).singleResult();
	System.out.println("任務ID："+m_task.getId());
	System.out.println("任務名稱："+m_task.getName());
}
}
