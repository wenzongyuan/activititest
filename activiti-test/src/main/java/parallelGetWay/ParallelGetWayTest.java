package parallelGetWay;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

/**
 * �������ز�����
 * @author Wen
 *
 */
public class ParallelGetWayTest {
   //��ȡ����������
	ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
	
	/**��������*/
	@Test
	public void deployMent(){
		//��ȡ������
		InputStream inputStreamBpmn=this.getClass().getResourceAsStream("/diagrams/shop.bpmn");
		InputStream inputStreamPng=this.getClass().getResourceAsStream("/diagrams/shop.png");
		Deployment deployMent=processEngine.getRepositoryService()
		             .createDeployment()
		             .name("��������")
		             .addInputStream("shop.bpmn", inputStreamBpmn)
		             .addInputStream("shop.png", inputStreamPng)
		             .deploy();
		
		System.out.println("�������");
		System.out.println("�������id:"+deployMent.getId());
		System.out.println("�����������:"+deployMent.getName());
	}
	
	
	/**��������*/
	@Test
	public void startProcess(){
		String businessKey="shop";
		//�������̱���
		Map<String,Object> vars=new HashMap<String,Object>();
		vars.put("userId", "wzy");
		vars.put("userId1", "twj");
		//��ʼ��������
		ProcessInstance pi=processEngine.getRuntimeService()
		             .startProcessInstanceByKey(businessKey, vars);
	
		System.out.println("�����ɹ���");
	    System.out.println("����ʵ��id:"+pi.getId());
		             
	}
	
	/**����ҵ�����*/
	@Test
	public void completeMyTask(){
		String tsakId="3802";
		//�������̱���
		Map<String,Object> vars=new HashMap<String,Object>();
		vars.put("userId", "wzy");
		//��ɴ�����
		processEngine.getTaskService()
		             .complete(tsakId, vars);
	}
}
