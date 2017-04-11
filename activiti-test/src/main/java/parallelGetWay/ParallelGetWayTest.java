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
 * 并行网关测试类
 * @author Wen
 *
 */
public class ParallelGetWayTest {
   //获取工作流引擎
	ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
	
	/**部署流程*/
	@Test
	public void deployMent(){
		//获取输入流
		InputStream inputStreamBpmn=this.getClass().getResourceAsStream("/diagrams/shop.bpmn");
		InputStream inputStreamPng=this.getClass().getResourceAsStream("/diagrams/shop.png");
		Deployment deployMent=processEngine.getRepositoryService()
		             .createDeployment()
		             .name("购物流程")
		             .addInputStream("shop.bpmn", inputStreamBpmn)
		             .addInputStream("shop.png", inputStreamPng)
		             .deploy();
		
		System.out.println("部署完成");
		System.out.println("部署对象id:"+deployMent.getId());
		System.out.println("部署对象名称:"+deployMent.getName());
	}
	
	
	/**启动流程*/
	@Test
	public void startProcess(){
		String businessKey="shop";
		//设置流程变量
		Map<String,Object> vars=new HashMap<String,Object>();
		vars.put("userId", "wzy");
		vars.put("userId1", "twj");
		//开始启动流程
		ProcessInstance pi=processEngine.getRuntimeService()
		             .startProcessInstanceByKey(businessKey, vars);
	
		System.out.println("启动成功！");
	    System.out.println("流程实例id:"+pi.getId());
		             
	}
	
	/**完成我的任务*/
	@Test
	public void completeMyTask(){
		String tsakId="3802";
		//设置流程变量
		Map<String,Object> vars=new HashMap<String,Object>();
		vars.put("userId", "wzy");
		//完成此任务
		processEngine.getTaskService()
		             .complete(tsakId, vars);
	}
}
