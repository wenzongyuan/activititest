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
 * ��ȡ���̶����ĵ���Դ
 * @author Wen
 *
 */
public class getProcessResources {
   //��ȡ����������
	ProcessEngine c_ProcessEngine =ProcessEngines.getDefaultProcessEngine();
	
	@Test
	public void getProcessDefResources() throws IOException{
		//���̲������id
		String m_DeploymentId="201";
		List<String> list=c_ProcessEngine.getRepositoryService().getDeploymentResourceNames(m_DeploymentId);
		
		String imageName=null;
		for(String name:list){
			if(name.indexOf("png")>0){
				imageName=name;
			}
		}
		
		System.out.println("ͼƬ���ƣ�"+imageName);
		
		if(imageName!=null){
			File file=new File("D:\\"+imageName);
			InputStream in=c_ProcessEngine.getRepositoryService().getResourceAsStream(m_DeploymentId, imageName);
			FileUtils.copyInputStreamToFile(in, file);
		}
		
		
		System.out.println("д��ͼƬ��ϣ�");
		              
	}
}
