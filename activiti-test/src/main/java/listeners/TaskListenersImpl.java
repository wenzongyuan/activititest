package listeners;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * ͨ���ද̬�ƶ�������
 * @author Wen
 *
 */
public class TaskListenersImpl implements TaskListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4900162953589235119L;

	@Override
	public void notify(DelegateTask delegateTask) {
		delegateTask.setAssignee("������");
		
	}

}
