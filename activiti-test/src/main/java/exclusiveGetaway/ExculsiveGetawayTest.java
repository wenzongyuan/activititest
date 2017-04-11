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
 * 排他网管和流程变量测试类
 * @author Wen
 *
 */
public class ExculsiveGetawayTest {
	
	ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
/**部署流程*/
	@Test
	public void deployMent(){
		InputStream InputStreamBpmn=this.getClass().getResourceAsStream("/diagrams/financeAudit.bpmn");
		InputStream InputStreamPng=this.getClass().getResourceAsStream("/diagrams/financeAudit.png");
		Deployment deployment=processEngine.getRepositoryService()
		             .createDeployment()
		             .name("财务审核流程")
		             .addInputStream("financeAudit.bpmn", InputStreamBpmn)
		             .addInputStream("financeAudit.png", InputStreamPng)
		             .deploy();
		System.out.println("部署对象id："+deployment.getId());
		System.out.println("部署对象名称："+deployment.getName());
	}
	
	/**启动流程*/
	@Test
	public void startProcess(){
		String businessKey="financeAudit";
		Map<String,Object> variables=new HashMap<String,Object>();
		variables.put("userId", "wenzongyuan");
		variables.put("money", 2000);
		ProcessInstance pi=	processEngine.getRuntimeService()
		             .startProcessInstanceByKey(businessKey, variables);
		
		System.out.println("财务审核流程启动成功！");
		System.err.println("流程实例ID："+pi.getId());
		System.out.println("流程实例的key:"+pi.getBusinessKey());
	}
	
	/**启动流程*/
	@Test
	public void startProcess1(){
		String businessKey="financeAudit";
		Map<String,Object> variables=new HashMap<String,Object>();
		variables.put("userId", "tangwenjing");
		variables.put("money", 800);
		ProcessInstance pi=	processEngine.getRuntimeService()
		             .startProcessInstanceByKey(businessKey, variables);
		
		System.out.println("财务审核流程启动成功！");
		System.err.println("流程实例ID："+pi.getId());
		System.out.println("流程实例的key:"+pi.getBusinessKey());
	}
	
	
	@Test
	public void completeMyTask(){
		String taskId="2903";
		Map<String,Object> variables=new HashMap<String,Object>();
		variables.put("userId", "weiyong");
		//完成任务
		processEngine.getTaskService()
		             .complete(taskId,variables);
		
		System.out.println("成功！");
	}
	
}
