package deployProcess;

import java.io.InputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
/**
 * �����������
 * @author Wen
 *
 */
public class deployProcess {
	ProcessEngine c_ProcessEngine=ProcessEngines.getDefaultProcessEngine();
	/**��������*/
  @Test
  public void deplymentProcess(){
	  InputStream inputStreamBpmn=this.getClass().getResourceAsStream("/diagrams/level.bpmn");
	  InputStream inputStreamPng=this.getClass().getResourceAsStream("/diagrams/level.png");
	 Deployment deployment= c_ProcessEngine.getRepositoryService().createDeployment()
	                                        .name("�������")
	                                        .addInputStream("level.bpmn", inputStreamBpmn)
	                                        .addInputStream("level.png", inputStreamPng)
	                                        .deploy();
	  System.out.println("�������ID:"+deployment.getId());
	  System.out.println("�����������:"+deployment.getName());
  }
}
