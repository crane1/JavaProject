package com.controller;


import java.util.Set;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.manager.ApplicationContains;
import com.model.UserInfo;

@WebListener
public class OnlineListener1 implements HttpSessionAttributeListener, HttpSessionListener {

    public OnlineListener1() {
    }

    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
    	HttpSession session = arg0.getSession();
    	String name = arg0.getName();
    	
    	if(name.equals("user")){
    		ApplicationContains.curUserCNT++;
    		UserInfo user_cur = (UserInfo)session.getAttribute("user");
    		
        	System.out.println("添加成功----------user个数"+ApplicationContains.curUserCNT);
        	
    		Set<String> keys = ApplicationContains.userMap.keySet();
    		System.out.println("session个数：" + ApplicationContains.userMap.size());
    		for(String k : keys){
    			HttpSession s = ApplicationContains.userMap.get(k);
    			UserInfo user_s = (UserInfo)s.getAttribute("user");
    			
    			if(user_cur!=null && user_s!=null && user_cur.equals(user_s)
    					&& !s.getId().equals(session.getId())){
    				String user_name = ((UserInfo)session.getAttribute("user")).getName();
    				System.out.println(user_name + "上线了！！！--------------");
    				s.invalidate();
    				return;
    			}
    		}
    		
    	}
    }

    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
    	String name = arg0.getName();
    	if(name.equals("user")){
    		ApplicationContains.curUserCNT--;
        	System.out.println("移除成功----------user个数"+ApplicationContains.curUserCNT);
    	}
    }

    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
    }

	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		ApplicationContains.userMap.put(session.getId(), session);
		System.out.println("session添加-------" + ApplicationContains.userMap.size());
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		ApplicationContains.userMap.remove(session.getId());
		System.out.println("session移除-------" + ApplicationContains.userMap.size());
	}
	
}
