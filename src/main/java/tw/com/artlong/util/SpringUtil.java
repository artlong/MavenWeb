package tw.com.artlong.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringUtil implements ApplicationContextAware {

	  private static ApplicationContext CONTEXT;
	  private static Map<Object, Object> jobs = new HashMap<Object, Object>();
	  
	  public static void setWorkingJob(Object jobId) {
		  jobs.put(jobId, jobId);
	  }
	  
	  public static boolean isJobWorking(Object jobId) {
		  return jobs.containsKey(jobId);
	  }
	  
	  public static void removeWorkingJob(Object jobId) {
		  jobs.remove(jobId);
	  }

	  /**
	   * This method is called from within the ApplicationContext once it is 
	   * done starting up, it will stick a reference to itself into this bean.
	   * @param context a reference to the ApplicationContext.
	   */
	  public void setApplicationContext(ApplicationContext context) throws BeansException {
	    CONTEXT = context;
	  }

	  /**
	   * This is about the same as context.getBean("beanName"), except it has its
	   * own static handle to the Spring context, so calling this method statically
	   * will give access to the beans by name in the Spring application context.
	   * As in the context.getBean("beanName") call, the caller must cast to the
	   * appropriate target class. If the bean does not exist, then a Runtime error
	   * will be thrown.
	   * @param beanName the name of the bean to get.
	   * @return an Object reference to the named bean.
	   */
	  public static Object getBean(String beanName) {
	    return CONTEXT.getBean(beanName);
	  }
}
