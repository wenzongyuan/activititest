package deployProcess;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.task.Task;
import org.junit.Test;
/**
 * ��ȡ���������ҵ�����ִ�е�����
 * @author Wen
 *
 */
public class getMyTask {
	
	//��ȡ����������
	ProcessEngine c_ProcessEngine=ProcessEngines.getDefaultProcessEngine();
@Test
public void getMyTask(){
	//���������� 
	String m_Assignee="����";
	Task m_task=c_ProcessEngine.getTaskService().createTaskQuery().taskAssignee(m_Assignee).singleResult();
	System.out.println("�΄�ID��"+m_task.getId());
	System.out.println("�΄����Q��"+m_task.getName());
}
}
