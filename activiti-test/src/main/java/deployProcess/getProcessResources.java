package deployProcess;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

/**
 * 获取流程定义文档资源
 * @author Wen
 *
 */
public class getProcessResources {
   //获取工作流引擎
	ProcessEngine c_ProcessEngine =ProcessEngines.getDefaultProcessEngine();
	
	@Test
	public void getProcessDefResources() throws IOException{
		//流程部署对象id
		String m_DeploymentId="201";
		List<String> list=c_ProcessEngine.getRepositoryService().getDeploymentResourceNames(m_DeploymentId);
		
		String imageName=null;
		for(String name:list){
			if(name.indexOf("png")>0){
				imageName=name;
			}
		}
		
		System.out.println("图片名称："+imageName);
		
		if(imageName!=null){
			File file=new File("D:\\"+imageName);
			InputStream in=c_ProcessEngine.getRepositoryService().getResourceAsStream(m_DeploymentId, imageName);
			FileUtils.copyInputStreamToFile(in, file);
		}
		
		
		System.out.println("写出图片完毕！");
		              
	}
}
