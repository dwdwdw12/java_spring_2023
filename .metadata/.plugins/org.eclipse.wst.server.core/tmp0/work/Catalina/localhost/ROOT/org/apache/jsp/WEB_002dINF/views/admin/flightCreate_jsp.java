/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.80
 * Generated at: 2023-12-15 04:15:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class flightCreate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("jar:file:/D:/javaWork/spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/project/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/D:/javaWork/spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/project/WEB-INF/lib/spring-security-taglibs-5.6.0.jar!/META-INF/security.tld", Long.valueOf(1636962998000L));
    _jspx_dependants.put("/WEB-INF/lib/spring-security-taglibs-5.6.0.jar", Long.valueOf(1700468393442L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1691733144298L));
    _jspx_dependants.put("jar:file:/D:/javaWork/spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/project/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700\">\r\n");
      out.write("<!-- Google web font \"Open Sans\" -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"../resources/font-awesome-4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("<!-- Font Awesome -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../resources/css/bootstrap.min.css\">\r\n");
      out.write("<!-- Bootstrap style -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("	href=\"../resources/css/datepicker.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("	href=\"../resources/slick/slick.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("	href=\"../resources/slick/slick-theme.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../resources/css/templatemo-style.css\">\r\n");
      out.write("<!-- Templatemo style -->\r\n");
      out.write("\r\n");
      out.write("<script src=\"../resources/js/jquery-1.11.3.min.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write(".col-xs-12 {\r\n");
      out.write("	width: 300px;\r\n");
      out.write("	margin: auto;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<!-- <div class=\"tm-page-wrap mx-auto\"> -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<section class=\"p-5 tm-container-outer tm-bg-gray\" style=\"max-width: 1600px;\">\r\n");
      out.write("	<div class=\"container\" style=\"max-width: 1600px;\">\r\n");
      out.write("		<div class=\"row\">\r\n");
      out.write("			<div class=\"col-xs-12 mx-auto tm-about-text-wrap text-center\">\r\n");
      out.write("				<h2 class=\"text-uppercase mb-4\">운항스케줄 등록</h2>\r\n");
      out.write("				<p class=\"mb-2\">양식에 맞게 정확히 기입 해 주세요.</p>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"row\">\r\n");
      out.write("			<div class=\"col-xs-6\">\r\n");
      out.write("				<table class=\"table table-hover\">\r\n");
      out.write("					<thead style=\"background: #ffc107\">\r\n");
      out.write("						<tr>\r\n");
      out.write("							<th style=\"width: 10%\">운항기</th>\r\n");
      out.write("							<th>출발지</th>\r\n");
      out.write("							<th>출발공항 코드</th>\r\n");
      out.write("							<!-- <th>출발지역 코드</th> -->\r\n");
      out.write("							<th>출발시간</th>\r\n");
      out.write("						</tr>\r\n");
      out.write("					</thead>\r\n");
      out.write("					<tbody>\r\n");
      out.write("						<tr class=\"flight\">\r\n");
      out.write("							<td><input type=\"text\" id=\"flightName\" name=\"flightName\"\r\n");
      out.write("								placeholder=\"OZ1155\" value=\"\" required=\"required\"\r\n");
      out.write("								style=\"border: 0; background-color: #efefef; width: 80px\" /></td>\r\n");
      out.write("							<td><input type=\"text\" id=\"depName\" name=\"depName\"\r\n");
      out.write("								placeholder=\"인천\" value=\"\" required=\"required\"\r\n");
      out.write("								style=\"border: 0; background-color: #efefef; width: 80px\" /></td>\r\n");
      out.write("							<td><select name=\"depCode\" id=\"depCode\"\r\n");
      out.write("								style=\"border: 0; background-color: #efefef; width: 80px\">\r\n");
      out.write("									");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("							</select></td>\r\n");
      out.write("\r\n");
      out.write("							<td><input type=\"text\" id=\"fullDepTime\" name=\"fullDepTime\"\r\n");
      out.write("								placeholder=\"2024-02-28 10:11:00\" value=\"\" required=\"required\"\r\n");
      out.write("								style=\"border: 0; background-color: #efefef; width: 160px\" /></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("\r\n");
      out.write("					</tbody>\r\n");
      out.write("\r\n");
      out.write("				</table>\r\n");
      out.write("			</div>\r\n");
      out.write("			\r\n");
      out.write("\r\n");
      out.write("			\r\n");
      out.write("			<div class=\"col-xs-6\">\r\n");
      out.write("				<table class=\"table table-hover\">\r\n");
      out.write("					<thead style=\"background: #ffc107\">\r\n");
      out.write("						<tr>\r\n");
      out.write("							<th>도착지</th>\r\n");
      out.write("							<th>도착공항 코드</th>\r\n");
      out.write("							<!-- <th>도착지역 코드</th> -->\r\n");
      out.write("							<th>도착시간</th>\r\n");
      out.write("							<th>비행시간</th>\r\n");
      out.write("						</tr>\r\n");
      out.write("					</thead>\r\n");
      out.write("					<tbody>\r\n");
      out.write("						<tr class=\"flight\">\r\n");
      out.write("							<td><input type=\"text\" id=\"arrName\" name=\"arrName\"\r\n");
      out.write("								placeholder=\"도쿄\" value=\"\" required=\"required\"\r\n");
      out.write("								style=\"border: 0; background-color: #efefef; width: 80px\" /></td>\r\n");
      out.write("							<!-- 								<td><input type=\"text\" id=\"arrCode\"/></td> -->\r\n");
      out.write("							<td><select id=\"aCode\" name=\"aCode\"\r\n");
      out.write("								style=\"border: 0; background-color: #efefef;\">\r\n");
      out.write("									");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("							</select></td>\r\n");
      out.write("							<!-- <td><input type=\"text\" id=\"arrRegionCode\"/></td> -->\r\n");
      out.write("\r\n");
      out.write("							<td><input type=\"text\" id=\"fullArrTime\" name=\"fullArrTime\"\r\n");
      out.write("								placeholder=\"2024-02-28 10:11:00\" value=\"\" required=\"required\"\r\n");
      out.write("								style=\"border: 0; background-color: #efefef; width: 160px\" /></td>\r\n");
      out.write("							<td><input type=\"text\" id=\"flightTime\" name=\"flightTime\"\r\n");
      out.write("								placeholder=\"1:05:00\" value=\"\" required=\"required\"\r\n");
      out.write("								style=\"border: 0; background-color: #efefef; width: 80px\" /></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("\r\n");
      out.write("					</tbody>\r\n");
      out.write("\r\n");
      out.write("				</table>\r\n");
      out.write("			</div>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("				<div class=\"row\">\r\n");
      out.write("					<div class=\"col-xs-12\">\r\n");
      out.write("						<button type=\"button\" class=\"btn btn-primary btn-sm btn-custom\"\r\n");
      out.write("							onclick=\"submit()\" style=\"width: 100%\">\r\n");
      out.write("							<i class=\"bi bi-chevron-double-right\"></i>&nbsp;등록\r\n");
      out.write("						</button>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("<!-- </div> -->\r\n");
      out.write("<!-- .tm-container-outer -->\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	console.log(\"dddd\");\r\n");
      out.write("	//유효성 체크\r\n");
      out.write("	function check() {\r\n");
      out.write("		  	var flightName = $(\"#flightName\").val();\r\n");
      out.write("		    var depName = $(\"#depName\").val();\r\n");
      out.write("		    var fullDepTime = $(\"#fullDepTime\").val();\r\n");
      out.write("		    var arrName = $(\"#arrName\").val();\r\n");
      out.write("		    var fullArrTime = $(\"#fullArrTime\").val();\r\n");
      out.write("		    var flightTime = $(\"#flightTime\").val();\r\n");
      out.write("\r\n");
      out.write("		    if (flightName.length < 1) {\r\n");
      out.write("		        alert(\"비행기 이름을 1자리 이상 입력하여 주십시오\");\r\n");
      out.write("		        return false;\r\n");
      out.write("		    }\r\n");
      out.write("		    if (depName.length < 1) {\r\n");
      out.write("		        alert(\"출발지 이름을 1자리 이상 입력하여 주십시오\");\r\n");
      out.write("		        return false;\r\n");
      out.write("		    }\r\n");
      out.write("		    if (fullDepTime.length < 1) {\r\n");
      out.write("		        alert(\"출발시간을 1자리 이상 입력하여 주십시오\");\r\n");
      out.write("		        return false;\r\n");
      out.write("		    }\r\n");
      out.write("		    if (arrName.length < 1) {\r\n");
      out.write("		        alert(\"도착지 이름을 1자리 이상 입력하여 주십시오\");\r\n");
      out.write("		        return false;\r\n");
      out.write("		    }\r\n");
      out.write("		    if (fullArrTime.length < 1) {\r\n");
      out.write("		        alert(\"도착시간을 1자리 이상 입력하여 주십시오\");\r\n");
      out.write("		        return false;\r\n");
      out.write("		    }\r\n");
      out.write("		    if (flightTime.length < 1) {\r\n");
      out.write("		        alert(\"비행시간을 1자리 이상 입력하여 주십시오\");\r\n");
      out.write("		        return false;\r\n");
      out.write("		    }\r\n");
      out.write("\r\n");
      out.write("		    return true; \r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	function submit() {\r\n");
      out.write("		alert(\"등록중..\")\r\n");
      out.write("		check();\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url : \"/admin/flightCreate\",\r\n");
      out.write("			type : \"POST\",\r\n");
      out.write("			//dataType : \"json\",\r\n");
      out.write("			async : true,\r\n");
      out.write("			contentType : \"application/json\",\r\n");
      out.write("			data : JSON.stringify({\r\n");
      out.write("				/* fno : $(\"#fno\").val(), */\r\n");
      out.write("				flightName : $(\"#flightName\").val(),\r\n");
      out.write("				depName : $(\"#depName\").val(),\r\n");
      out.write("				depCode : $(\"#depCode\").val(),\r\n");
      out.write("				//depRegionCode : $(\"#dRCode\").val(),\r\n");
      out.write("				fullDeptime : $(\"#fullDepTime\").val(),\r\n");
      out.write("				arrName : $(\"#arrName\").val(),\r\n");
      out.write("				arrCode : $(\"#aCode\").val(),\r\n");
      out.write("				//arrRegionCode : $(\"#aRCode\").val(),\r\n");
      out.write("				fullArrtime : $(\"#fullArrTime\").val(),\r\n");
      out.write("				flightTime : $(\"#flightTime\").val()\r\n");
      out.write("\r\n");
      out.write("			}),\r\n");
      out.write("			success : function(data) {\r\n");
      out.write("				console.log(data);\r\n");
      out.write("				window.close();\r\n");
      out.write("				/* 			location.href=\"admin/flightSchedule\"; */\r\n");
      out.write("			},\r\n");
      out.write("			error : function(err) {\r\n");
      out.write("				console.log(err);\r\n");
      out.write("				/* 			console.log(err.responseText); // 서버에서 전송한 오류 메시지\r\n");
      out.write("				 console.log(err.status);  */\r\n");
      out.write("				alert(\"항공스케줄 업로드에 실패했습니다!\");\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/views/admin/flightCreate.jsp(66,9) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/admin/flightCreate.jsp(66,9) '${depCode}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${depCode}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/views/admin/flightCreate.jsp(66,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("dCode");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("										<option value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dCode}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dCode}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</option>\r\n");
            out.write("									");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f1_reused = false;
    try {
      _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f1.setParent(null);
      // /WEB-INF/views/admin/flightCreate.jsp(107,9) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/admin/flightCreate.jsp(107,9) '${arrCode}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${arrCode}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/views/admin/flightCreate.jsp(107,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setVar("aCode");
      int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
        if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("										<option value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${aCode}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${aCode}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</option>\r\n");
            out.write("									");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f1.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
      _jspx_th_c_005fforEach_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f1_reused);
    }
    return false;
  }
}
