package ProcessBasic;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
/**
 * 启动请假流程
 * @author Wen 
 *
 */
public class startProcrss {
	
	//获取工作流引擎
	ProcessEngine c_processEngine=ProcessEngines.getDefaultProcessEngine();
	
	/**启动流程*/
  @Test
  public void startProcess(){
    //流程定义的key值
	  String m_Key="my_level_process";
	  //通过流程定义的key值启动流程
	  ProcessInstance m_ProcessInstance =c_processEngine.getRuntimeService().startProcessInstanceByKey(m_Key);
	  System.out.println("启动完成！");
	  System.out.println("流程实例ID："+m_ProcessInstance.getId());
	  System.out.println("流程实例ID："+m_ProcessInstance.getProcessInstanceId());
	  System.out.println("流程定义ID："+m_ProcessInstance.getProcessDefinitionId());
  }
}
