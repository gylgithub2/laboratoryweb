/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.30
 * Generated at: 2020-04-25 12:21:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.page.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class laboratory_002dmanager_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<table id=\"lab-table\" style=\"width: 100%;height:100%;\" />\r\n");
      out.write("\t<div id=\"lab-tb\">\r\n");
      out.write("\t\t<div class=\"lab-Toolbar_button\"></div>\r\n");
      out.write("\t\t<a href=\"javascript:void(0);\" data-options=\"iconCls:'icon-add'\" id=\"addbutton\"\r\n");
      out.write("\t\t\tclass=\"easyui-linkbutton\" onclick=\"addLaboratory()\">添加</a> &nbsp; <a\r\n");
      out.write("\t\t\thref=\"javascript:void(0);\" data-options=\"iconCls:'icon-save'\" id=\"updatebutton\"\r\n");
      out.write("\t\t\tclass=\"easyui-linkbutton\" onclick=\"updateLaboratory()\">修改</a>&nbsp;\r\n");
      out.write("\t\t<a href=\"javascript:void(0);\" data-options=\"iconCls:'icon-remove'\" id=\"removebutton\"\r\n");
      out.write("\t\t\tclass=\"easyui-linkbutton\" onclick=\"deleteLaboratory()\">删除</a> &nbsp;\r\n");
      out.write("\t\t<a href=\"javascript:void(0);\" data-options=\"iconCls:'icon-cancel'\" id=\"cancelbutton\"\r\n");
      out.write("\t\t\tclass=\"easyui-linkbutton\" onclick=\"cancelL()\">取消选择</a>\r\n");
      out.write("\t\t&nbsp;实验室名:\r\n");
      out.write("\t\t<div id=\"searcher_laboratoryName\" prompt=\"实验室名字...\" class=\"easyui-textbox\"></div>\r\n");
      out.write("\t\t&nbsp; <a href=\"javascript:void(0);\" data-options=\"iconCls:'icon-search'\" id=\"lab-searcherbutton\" class=\"easyui-linkbutton\">搜索</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 增加的提示框 -->\r\n");
      out.write("\t<div id=\"lab-dialog\" class=\"easyui-dialog\"\r\n");
      out.write("\t\tdata-options=\"closed:true,iconCls:'icon-save'\"\r\n");
      out.write("\t\tstyle=\"width: 350px; height: 330px; padding: 10px;\">\r\n");
      out.write("\t\t<form id=\"lab-dialog-form\" method=\"post\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"90px\" align=\"right\">实验室名:&nbsp;\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" id=\"laboratoryPKID\" name=\"laboratoryPKID\" /> </td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"laboratoryName\"\r\n");
      out.write("\t\t\t\t\t\tname=\"laboratoryName\" class=\"easyui-textbox\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"90px\" align=\"right\">实验室编号:&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"laboratoryId\"\r\n");
      out.write("\t\t\t\t\t\tname=\"laboratoryId\" class=\"easyui-numberbox\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"90px\" align=\"right\">座位数:&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"laboratorySitNum\"\r\n");
      out.write("\t\t\t\t\t\tname=\"laboratorySitNum\" class=\"easyui-numberbox\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"90px\" align=\"right\">实验室状态:&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"laboratoryStatus\"\r\n");
      out.write("\t\t\t\t\t\tname=\"laboratoryStatus\" \tclass=\"easyui-combotree\" data-options=\"panelHeight:99\"  /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$('#laboratoryStatus').combotree('loadData', [{\r\n");
      out.write("\t\t\t\tid : 2,\r\n");
      out.write("\t\t\t\ttext : '禁用',\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tid : 1,\r\n");
      out.write("\t\t\t\ttext : '正常',\r\n");
      out.write("\t\t\t} ]);\r\n");
      out.write("\t\t\t$(\"#lab-table\").datagrid({\r\n");
      out.write("\t\t\t\ttitle : \"实验室信息表\",\r\n");
      out.write("\t\t\t\turl : \"/laboratoryweb/getPagerLaboratorys\",\r\n");
      out.write("\t\t\t\tpagination : true,\r\n");
      out.write("\t\t\t\tpageSize : 15,\r\n");
      out.write("\t\t\t\tpageList : [ 15, 50, 100 ],\r\n");
      out.write("\t\t\t\tcolumns : [ [ {\r\n");
      out.write("\t\t\t\t\tfield : \"ck\",\r\n");
      out.write("\t\t\t\t\tcheckbox : \"true\"\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\tfield : \"laboratoryPKID\",\r\n");
      out.write("\t\t\t\t\thidden: true,\r\n");
      out.write("\t\t\t\t\ttitle : \"laboratoryPKID\"\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t},{\r\n");
      out.write("\t\t\t\t\tfield : \"laboratoryId\",\r\n");
      out.write("\t\t\t\t\tsortable : true,\r\n");
      out.write("\t\t\t\t\ttitle : \"实验室编号\",\r\n");
      out.write("\t\t\t\t\twidth : 100\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\tfield : \"laboratoryName\",\r\n");
      out.write("\t\t\t\t\ttitle : \"实验室名字\",\r\n");
      out.write("\t\t\t\t\twidth : 100\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\tfield : \"laboratorySitNum\",\r\n");
      out.write("\t\t\t\t\ttitle : \"实验室座位数量\",\r\n");
      out.write("\t\t\t\t\twidth : 100\r\n");
      out.write("\t\t\t\t},  {\r\n");
      out.write("\t\t\t\t\tfield : \"laboratoryStatus\",\r\n");
      out.write("\t\t\t\t\ttitle : \"实验室状态\",\r\n");
      out.write("\t\t\t\t\twidth : 100,\r\n");
      out.write("\t\t\t\t\tformatter:function(value,row,index){\r\n");
      out.write("\t\t\t\t\t\tif(value==1){\r\n");
      out.write("\t\t\t\t\t\t\treturn \"正常\";\r\n");
      out.write("\t\t\t\t\t\t}else if(value==2){\r\n");
      out.write("\t\t\t\t\t\t\treturn \"禁用\";\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},]],\r\n");
      out.write("\t\t\t\tstriped : true,\r\n");
      out.write("\t\t\t\ttoolbar : \"#lab-tb\",\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"#lab-searcherbutton\")\r\n");
      out.write("\t\t\t\t\t.click(\r\n");
      out.write("\t\t\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t\t\tvar laboratoryName = $(\"#searcher_laboratoryName\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.textbox(\"getValue\");\r\n");
      out.write("\t\t\t\t\t\t\t\tvar queryParam = $(\"#lab-table\").datagrid(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\"options\").queryParams;\r\n");
      out.write("\t\t\t\t\t\t\t\tqueryParam.laboratoryName = laboratoryName;\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#lab-table\").datagrid(\"load\");\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("function addLaboratory() {\r\n");
      out.write("\t\t\t$(\"#lab-dialog-form\").form(\"clear\");\r\n");
      out.write("\t\t\t$(\"#lab-dialog\").dialog({\r\n");
      out.write("\t\t\t\ttitle:\"增加用户\",\r\n");
      out.write("\t\t\t\tclosed:false,\r\n");
      out.write("\t\t\t\tmodal:true,\r\n");
      out.write("\t\t\t\tonOpen:function(){\r\n");
      out.write("\t\t\t\t\t$(\"#laboratoryName\").textbox({disabled:false});\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tbuttons:[ //按钮\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\ttext:\"确定\",\r\n");
      out.write("\t\t\t\t\ticonCls:\"icon-ok\",\r\n");
      out.write("\t\t\t\t\thandler: laboratory_add\r\n");
      out.write("\t\t\t\t    },\r\n");
      out.write("\t\t\t\t    {     text:'取消',iconCls:\"icon-cancel\",\r\n");
      out.write("\t\t\t\t\t    handler:function(){\r\n");
      out.write("\t\t\t\t\t\t$(\"#lab-dialog\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t       \t}\r\n");
      out.write("\t\t\t\t    \r\n");
      out.write("\t\t\t\t       ]\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t} \r\n");
      out.write("\t\tfunction updateLaboratory(){\r\n");
      out.write("\t\t\t$(\"#lab-dialog-form\").form(\"clear\");\r\n");
      out.write("\t\t\tvar rows = $(\"#lab-table\").datagrid(\"getSelections\");\r\n");
      out.write("\t\t\tif(rows.length!=1){\t\t\r\n");
      out.write("\t\t\t\t$.messager.alert(\"提示\",\"请选择一条信息\",\"info\");\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tvar laboratory = rows[0];\r\n");
      out.write("\t\t\t\t//表单绑定数据\r\n");
      out.write("\t\t\t\t$(\"#lab-dialog-form\").form(\"load\",laboratory);\r\n");
      out.write("\t\t\t\t$(\"#lab-dialog\").dialog({\r\n");
      out.write("\t\t\t\t\ttitle:\"修改实验室信息\",\r\n");
      out.write("\t\t\t\t\tclosed:false,\r\n");
      out.write("\t\t\t\t\tmodal:true,\r\n");
      out.write("\t\t\t\t\t//不可修改\r\n");
      out.write("/* \t\t\t\t\tonOpen:function(){\r\n");
      out.write("\t\t\t\t\t\t$(\"#laboratoryName\").textbox({disabled:true});\r\n");
      out.write("\t\t\t\t\t}, */\r\n");
      out.write("\t\t\t\t\tbuttons:[ //按钮\r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\ttext:\"确定\",\r\n");
      out.write("\t\t\t\t\t\ticonCls:\"icon-ok\",\r\n");
      out.write("\t\t\t\t\t\thandler:laboratory_update\r\n");
      out.write("\t\t\t\t\t    },\r\n");
      out.write("\t\t\t\t\t    {     text:'取消',iconCls:\"icon-cancel\",\r\n");
      out.write("\t\t\t\t\t\t    handler:function(){\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#lab-dialog\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t       \t}\r\n");
      out.write("\t\t\t\t\t    \r\n");
      out.write("\t\t\t\t\t       ]\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction laboratory_add(){\r\n");
      out.write("\t\t\tdoAjaxL(\"/laboratoryweb/addLaboratory\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction laboratory_update(){\r\n");
      out.write("\t\t\tdoAjaxL(\"/laboratoryweb/updateLaboratory\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction doAjaxL(param){\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:param,\r\n");
      out.write("\t\t\t\tmethod:\"post\",\r\n");
      out.write("\t\t\t\tcontentType : \"application/json;charset=utf-8\",\r\n");
      out.write("\t\t\t\tdata:JSON.stringify({\r\n");
      out.write("\t\t\t\t\tlaboratoryPKID:$(\"#laboratoryPKID\").val(),\r\n");
      out.write("\t\t\t\t\tlaboratoryName:$(\"#laboratoryName\").val(),\r\n");
      out.write("\t\t\t\t\tlaboratoryId:$(\"#laboratoryId\").val(),\r\n");
      out.write("\t\t\t\t\tlaboratorySitNum:$(\"#laboratorySitNum\").val(),\r\n");
      out.write("\t\t\t\t\tlaboratoryStatus:$(\"#laboratoryStatus\").val(),\r\n");
      out.write("\t\t\t\t}),\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\tif (data == \"ok\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#lab-dialog\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#lab-table\").datagrid(\"reload\");\r\n");
      out.write("\t\t\t\t\t\tAlert(\"操作成功!\");\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\tAlert(\"请重试！\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction deleteLaboratory(){\r\n");
      out.write("\t\t\t\t\tvar rows = $(\"#lab-table\").datagrid(\"getSelections\");\r\n");
      out.write("\t\t\t\t\tif(rows.length>=1){\t\r\n");
      out.write("\t\t\t$.messager.confirm(\"提示\",\"确定删除?\",function(result){\r\n");
      out.write("\t\t\t\tif(result){\r\n");
      out.write("\t\t\t\t\tvar ids=[];\r\n");
      out.write("\t\t\t\t\t$(rows).each(function(){\r\n");
      out.write("\t\t\t\t\t\tids.push(this.laboratoryPKID);\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\turl:\"/laboratoryweb/deleteLaboratory\",\r\n");
      out.write("\t\t\t\t\t\tdata:{ids:ids},\r\n");
      out.write("\t\t\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\t\t\tif (data == \"ok\") {\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#lab-dialog\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#lab-table\").datagrid(\"reload\");\r\n");
      out.write("\t\t\t\t\t\t\t\tAlert(\"删除成功!\");\r\n");
      out.write("\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\tAlert(\"删除失败！\");\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert(\"提示\",\"请至少选择一条记录！\",\"info\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction cancelL(){\r\n");
      out.write("\t\t\t$(\"#lab-table\").datagrid(\"rejectChanges\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
