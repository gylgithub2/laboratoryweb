/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.30
 * Generated at: 2020-05-14 07:27:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.page.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class t_002dwatch_002dvideo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<title>视频观看</title>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/jquery/jquery.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/video-js.min.css\" />\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/video.min.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("\tbackground-color: #191919;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".m {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("\tmargin-left: auto;\r\n");
      out.write("\tmargin-right: auto;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t   \r\n");
      out.write("\t<input id=\"stuId\" type=\"hidden\"\r\n");
      out.write("\t\tvalue=\"");
      out.print(session.getAttribute("userAccount"));
      out.write("\" />\r\n");
      out.write("\t<div class=\"m\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<video id=\"expervideo\"\r\n");
      out.write("\t\t\tclass=\"video-js vjs-default-skin  vjs-big-play-centered\"\r\n");
      out.write("\t\t\tcontrols=\"controls\" preload=\"auto\" width=\"1500\" height=\"680\"\r\n");
      out.write("\t\t\twebkit-playsinline=\"true\" onended=\"over()\" playsinline=\"\"\r\n");
      out.write("\t\t\tx5-playsinline=\"\" data-setup='{\"example_option\":true}'>      \r\n");
      out.write("\t\t<source\r\n");
      out.write("\t\t\tsrc=\"/laboratoryweb/resources/videos/");
      out.print(session.getAttribute("videoPath"));
      out.write("\"\r\n");
      out.write("\t\t\ttype='video/mp4' />              </video>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar that = this;\r\n");
      out.write("\tvar resetTime = 0; // 拖动后重置播放时间\r\n");
      out.write("\tvar curTime = 0; // 当前播放时间\r\n");
      out.write("\tvar vd = document.getElementById(\"expervideo\"); //获取video对象\r\n");
      out.write("\tvar getCurTime = localStorage.getItem('remTime'); //获取本地存储\r\n");
      out.write("\tif (getCurTime > 0.1) {\r\n");
      out.write("\t\tcurTime = getCurTime;\r\n");
      out.write("\t\tresetTime = getCurTime;\r\n");
      out.write("\t\tvd.addEventListener('play', function() {\r\n");
      out.write("\t\t\tsetTimeout(function() {\r\n");
      out.write("\t\t\t\tvd.currentTime = getCurTime;\r\n");
      out.write("\t\t\t\tsetInterval(timer, 100)\r\n");
      out.write("\t\t\t}, 2000)\r\n");
      out.write("\t\t})\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\tvd.play();\r\n");
      out.write("\t\tsetInterval(timer, 100)\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t// 定时器\r\n");
      out.write("\tfunction timer() {\r\n");
      out.write("\t\tcurTime = vd.currentTime;\r\n");
      out.write("\t\tvar apartTime = curTime - resetTime;\r\n");
      out.write("\t\tif (apartTime > 2) {\r\n");
      out.write("\t\t\tvd.currentTime = resetTime;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tresetTime = curTime;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tthat.curTime = curTime;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tvd.addEventListener('pause', function() {\r\n");
      out.write("\t\tlocalStorage.setItem('remTime', that.curTime);\r\n");
      out.write("\t})\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\tvar myPlayer = videojs('expervideo');\r\n");
      out.write("\t\tvar myInterval = setInterval(storeDuration, 5000);\r\n");
      out.write("\t\tfunction storeDuration() {\r\n");
      out.write("\t\t\tvar myPlayer = videojs('expervideo');\r\n");
      out.write("\t\t\tvar videoTime = myPlayer.duration();\r\n");
      out.write("\t\t\tvar watchTime = myPlayer.currentTime();\r\n");
      out.write("\t\t\tvar stuId = $(\"#stuId\").val();\r\n");
      out.write("\t\t\tvar data = {\r\n");
      out.write("\t\t\t\t\"stuId\" : stuId,\r\n");
      out.write("\t\t\t\t\"videoTime\" : videoTime,\r\n");
      out.write("\t\t\t\t\"watchTime\" : watchTime\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\tasync : true,\r\n");
      out.write("\t\t\t\turl : \"/laboratoryweb/stuWatchLog\",\r\n");
      out.write("\t\t\t\ttype : \"POST\",\r\n");
      out.write("\t\t\t\tdata : data,\r\n");
      out.write("\t\t\t\tsuccess : function(msg) {\r\n");
      out.write("\t\t\t\t\tif (msg == \"watched\") {\r\n");
      out.write("\t\t\t\t\t\talert(\"学习完毕\");\r\n");
      out.write("\t\t\t\t\t\tclearInterval(myInterval);\r\n");
      out.write("\t\t\t\t\t} else if (msg == \"overDate\") {\r\n");
      out.write("\t\t\t\t\t\talert(\"已过学习日期\");\r\n");
      out.write("\t\t\t\t\t\tclearInterval(myInterval);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tif (videoTime == watchTime) {\r\n");
      out.write("\t\t\t\tclearInterval(myInterval);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t})\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
