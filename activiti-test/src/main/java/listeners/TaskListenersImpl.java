package listeners;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * 通过类动态制定办理人
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
		delegateTask.setAssignee("唐三藏");
		
	}

}
