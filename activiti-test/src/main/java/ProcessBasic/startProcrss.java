package ProcessBasic;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
/**
 * �����������
 * @author Wen 
 *
 */
public class startProcrss {
	
	//��ȡ����������
	ProcessEngine c_processEngine=ProcessEngines.getDefaultProcessEngine();
	
	/**��������*/
  @Test
  public void startProcess(){
    //���̶����keyֵ
	  String m_Key="my_level_process";
	  //ͨ�����̶����keyֵ��������
	  ProcessInstance m_ProcessInstance =c_processEngine.getRuntimeService().startProcessInstanceByKey(m_Key);
	  System.out.println("������ɣ�");
	  System.out.println("����ʵ��ID��"+m_ProcessInstance.getId());
	  System.out.println("����ʵ��ID��"+m_ProcessInstance.getProcessInstanceId());
	  System.out.println("���̶���ID��"+m_ProcessInstance.getProcessDefinitionId());
  }
}
