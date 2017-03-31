package processVarlable;

import java.io.InputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

/**
 * ���̱�������������
 * @author Wen
 *
 */
public class VarlablesTest {
  //��ȡ����������
	ProcessEngine c_ProcessEngine=ProcessEngines.getDefaultProcessEngine();
	
	/**�������̶���*/
	@Test
	public void deploymentProcess(){
		//��ȡ��Դ�ļ�������
		InputStream inputStreamBpmn=this.getClass().getResourceAsStream("/diagrams/newLevel.bpmn");
		InputStream inputStreamPng=this.getClass().getResourceAsStream("/diagrams/newLevel.png");
		//��ʼ�������̶��岢�ҷ��ز������
	    Deployment deployment=c_ProcessEngine.getRepositoryService()
		                .createDeployment()
		                .name("�µ��������")
		                .addInputStream("newLevel.bpmn",inputStreamBpmn)
		                .addInputStream("newLevel.png", inputStreamPng)
		                .deploy();
	    
	    System.out.println("������ɣ�");
	    System.out.println("���� ����ʵ������ID��"+deployment.getId());  //501
	    System.out.println("���� ����ʵ������name��"+deployment.getName());//�µ��������
	}
	
	
	/**�������̲����ò���*/
	@Test
	public void startProcess(){
		//ͨ��keyֵ��������ʵ�������̶����key,����bpmnͼ��IDֵ��
		String key="new_my_level";
		//�������̲���������ʵ��
		ProcessInstance processInstance=c_ProcessEngine.getRuntimeService()
		               .startProcessInstanceByKey(key);
		c_ProcessEngine.getRuntimeService().setVariable(processInstance.getId(), "�������", 5);
		System.out.println("�������");
		               
	}
	
}
