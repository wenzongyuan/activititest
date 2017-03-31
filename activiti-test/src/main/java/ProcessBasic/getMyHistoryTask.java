package ProcessBasic;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

/**
 * 获取我的历史任务
 * @author Wen 
 *
 */
public class getMyHistoryTask {  
	
	//获取工作流引擎
	ProcessEngine c_ProcessEngine=ProcessEngines.getDefaultProcessEngine();
   @Test
   public void getMyHistoryTask(){
	 //办理人名称 
	 String m_Assignee="张三";
	 List<HistoricTaskInstance> m_List=  c_ProcessEngine.getHistoryService().createHistoricTaskInstanceQuery()
	                                      .taskAssignee(m_Assignee)
	                                      .orderByHistoricTaskInstanceEndTime()
	                                      .desc()
	                                      .list();
	 
	 for(HistoricTaskInstance task: m_List){
		 System.out.println("任务id："+task.getId());
		 System.out.println("任务名称："+task.getName());
		 System.out.println("任务办理人："+task.getAssignee());
	 }
   }
}
