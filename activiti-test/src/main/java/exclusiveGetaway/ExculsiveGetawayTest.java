package exclusiveGetaway;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

/**
 * �������ܺ����̱���������
 * @author Wen
 *
 */
public class ExculsiveGetawayTest {
	
	ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
/**��������*/
	@Test
	public void deployMent(){
		InputStream InputStreamBpmn=this.getClass().getResourceAsStream("/diagrams/financeAudit.bpmn");
		InputStream InputStreamPng=this.getClass().getResourceAsStream("/diagrams/financeAudit.png");
		Deployment deployment=processEngine.getRepositoryService()
		             .createDeployment()
		             .name("�����������")
		             .addInputStream("financeAudit.bpmn", InputStreamBpmn)
		             .addInputStream("financeAudit.png", InputStreamPng)
		             .deploy();
		System.out.println("�������id��"+deployment.getId());
		System.out.println("����������ƣ�"+deployment.getName());
	}
	
	/**��������*/
	@Test
	public void startProcess(){
		String businessKey="financeAudit";
		Map<String,Object> variables=new HashMap<String,Object>();
		variables.put("userId", "wenzongyuan");
		variables.put("money", 2000);
		ProcessInstance pi=	processEngine.getRuntimeService()
		             .startProcessInstanceByKey(businessKey, variables);
		
		System.out.println("����������������ɹ���");
		System.err.println("����ʵ��ID��"+pi.getId());
		System.out.println("����ʵ����key:"+pi.getBusinessKey());
	}
	
	/**��������*/
	@Test
	public void startProcess1(){
		String businessKey="financeAudit";
		Map<String,Object> variables=new HashMap<String,Object>();
		variables.put("userId", "tangwenjing");
		variables.put("money", 800);
		ProcessInstance pi=	processEngine.getRuntimeService()
		             .startProcessInstanceByKey(businessKey, variables);
		
		System.out.println("����������������ɹ���");
		System.err.println("����ʵ��ID��"+pi.getId());
		System.out.println("����ʵ����key:"+pi.getBusinessKey());
	}
	
	
	@Test
	public void completeMyTask(){
		String taskId="2903";
		Map<String,Object> variables=new HashMap<String,Object>();
		variables.put("userId", "weiyong");
		//�������
		processEngine.getTaskService()
		             .complete(taskId,variables);
		
		System.out.println("�ɹ���");
	}
	
}
