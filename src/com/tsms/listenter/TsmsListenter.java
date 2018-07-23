package com.tsms.listenter;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class TsmsListenter
 *
 */
@WebListener
public class TsmsListenter implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public TsmsListenter() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event)  { 
		ServletContext context = event.getSession().getServletContext();
		Object online = context.getAttribute("online");
		if (online == null) {
			context.setAttribute("online", 1);
		} else {
			Integer v = (Integer) online;
			context.setAttribute("online", ++v);
		}
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event)  { 
		ServletContext context = event.getSession().getServletContext();
		Object online = context.getAttribute("online");
		if(online==null){
			return;
		}
		Integer v=(Integer) online;
		context.setAttribute("online",--v );
	

    }
	
}
