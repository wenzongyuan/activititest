package listeners;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

/**
 * �ද̬���ð�����test
 * @author Wen
 *
 */
public class ListenersTest {

	 //��ȡ����������
		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
		
		/**��������*/
		@Test
		public void deployMent(){
			//��ȡ������
			InputStream inputStreamBpmn=this.getClass().getResourceAsStream("/diagrams/listener.bpmn");
			InputStream inputStreamPng=this.getClass().getResourceAsStream("/diagrams/listener.png");
			Deployment deployMent=processEngine.getRepositoryService()
			             .createDeployment()
			             .name("�ද̬��������")
			             .addInputStream("listener.bpmn", inputStreamBpmn)
			             .addInputStream("listener.png", inputStreamPng)
			             .deploy();
			
			System.out.println("�������");
			System.out.println("�������id:"+deployMent.getId());
			System.out.println("�����������:"+deployMent.getName());
		}
		
		
		/**��������*/
		@Test
		public void startProcess(){
			String businessKey="listener";
			//��ʼ��������
			ProcessInstance pi=processEngine.getRuntimeService()
			             .startProcessInstanceByKey(businessKey);
		
			System.out.println("�����ɹ���");
		    System.out.println("����ʵ��id:"+pi.getId());
			             
		}
		
		/**����ҵ�����*/
		@Test
		public void completeMyTask(){
			String tsakId="4502";
			//��ɴ�����
			processEngine.getTaskService()
			             .complete(tsakId);
		}
}
