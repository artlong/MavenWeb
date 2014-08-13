package tw.com.artlong.init;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import tw.com.artlong.util.PropertyUtils;
import tw.com.artlong.util.SpringUtil;


@SuppressWarnings("serial")
public class InitialServlet extends HttpServlet {

	private Logger log = Logger.getLogger(InitialServlet.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log.info("************** HelloMaven Server 啟動 - [ " + PropertyUtils.getEnvironmentMode() + " ] **************");
		Object dataSource = SpringUtil.getBean("dataSource");
		log.info("************** is Spring ready ? dataSource [ " + dataSource + " ] **************");
	}
}
