package processVarlable;

import java.io.InputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

/**
 * 流程变量基础测试类
 * @author Wen
 *
 */
public class VarlablesTest {
  //获取工作流引擎
	ProcessEngine c_ProcessEngine=ProcessEngines.getDefaultProcessEngine();
	
	/**部署流程定义*/
	@Test
	public void deploymentProcess(){
		//获取资源文件输入流
		InputStream inputStreamBpmn=this.getClass().getResourceAsStream("/diagrams/newLevel.bpmn");
		InputStream inputStreamPng=this.getClass().getResourceAsStream("/diagrams/newLevel.png");
		//开始部署流程定义并且返回部署对象
	    Deployment deployment=c_ProcessEngine.getRepositoryService()
		                .createDeployment()
		                .name("新的请假流程")
		                .addInputStream("newLevel.bpmn",inputStreamBpmn)
		                .addInputStream("newLevel.png", inputStreamPng)
		                .deploy();
	    
	    System.out.println("部署完成！");
	    System.out.println("流程 部署实例对象ID："+deployment.getId());  //501
	    System.out.println("流程 部署实例对象name："+deployment.getName());//新的请假流程
	}
	
	
	/**启动流程并设置参数*/
	@Test
	public void startProcess(){
		//通过key值启动流程实例（流程定义的key,就是bpmn图的ID值）
		String key="new_my_level";
		//启动流程并返回流程实例
		ProcessInstance processInstance=c_ProcessEngine.getRuntimeService()
		               .startProcessInstanceByKey(key);
		c_ProcessEngine.getRuntimeService().setVariable(processInstance.getId(), "请假天数", 5);
		System.out.println("启动完成");
		               
	}
	
}
