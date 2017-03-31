package ProcessBasic;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

/**
 * ��ȡ�ҵ���ʷ����
 * @author Wen 
 *
 */
public class getMyHistoryTask {  
	
	//��ȡ����������
	ProcessEngine c_ProcessEngine=ProcessEngines.getDefaultProcessEngine();
   @Test
   public void getMyHistoryTask(){
	 //���������� 
	 String m_Assignee="����";
	 List<HistoricTaskInstance> m_List=  c_ProcessEngine.getHistoryService().createHistoricTaskInstanceQuery()
	                                      .taskAssignee(m_Assignee)
	                                      .orderByHistoricTaskInstanceEndTime()
	                                      .desc()
	                                      .list();
	 
	 for(HistoricTaskInstance task: m_List){
		 System.out.println("����id��"+task.getId());
		 System.out.println("�������ƣ�"+task.getName());
		 System.out.println("��������ˣ�"+task.getAssignee());
	 }
   }
}
