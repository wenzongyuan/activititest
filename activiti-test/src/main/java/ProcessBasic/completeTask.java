package ProcessBasic;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;
/**
 * 完成我的个任务
 * @author Wen
 *
 */
public class completeTask {
	
	//获取工作流引擎
	ProcessEngine c_ProcessEngine=ProcessEngines.getDefaultProcessEngine();
   @Test
    public void completeMyTask(){
	//任務ID
	String m_TaskId="602";
	c_ProcessEngine.getTaskService().complete(m_TaskId);
	System.out.println("完成任務！");
    }
}
