package ProcessBasic;

import java.io.InputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
/**
 * 部署请假流程
 * @author Wen
 *
 */
public class deployProcess {
	ProcessEngine c_ProcessEngine=ProcessEngines.getDefaultProcessEngine();
	/**部署流程*/
  @Test
  public void deplymentProcess(){
	  InputStream inputStreamBpmn=this.getClass().getResourceAsStream("/diagrams/level.bpmn");
	  InputStream inputStreamPng=this.getClass().getResourceAsStream("/diagrams/level.png");
	 Deployment deployment= c_ProcessEngine.getRepositoryService().createDeployment()
	                                        .name("请假流程")
	                                        .addInputStream("level.bpmn", inputStreamBpmn)
	                                        .addInputStream("level.png", inputStreamPng)
	                                        .deploy();
	  System.out.println("部署对象ID:"+deployment.getId());
	  System.out.println("部署对象名称:"+deployment.getName());
  }
}
