package ProcessBasic;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;
/**
 * ����ҵĸ�����
 * @author Wen
 *
 */
public class completeTask {
	
	//��ȡ����������
	ProcessEngine c_ProcessEngine=ProcessEngines.getDefaultProcessEngine();
   @Test
    public void completeMyTask(){
	//�΄�ID
	String m_TaskId="602";
	c_ProcessEngine.getTaskService().complete(m_TaskId);
	System.out.println("����΄գ�");
    }
}
