/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.80
 * Generated at: 2023-12-06 07:36:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write(" <head>\r\n");
      out.write("  <meta charset=\"UTF-8\">\r\n");
      out.write("  <base target=\"_top\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://ssl.gstatic.com/docs/script/css/add-ons.css\" />\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css\">\r\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js\"></script>\r\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  <script>\r\n");
      out.write("    \r\n");
      out.write("    $(function() \r\n");
      out.write("    {\r\n");
      out.write("        var data = [\r\n");
      out.write("              \"LG전자\",\r\n");
      out.write("              \"LG전자우\"\r\n");
      out.write("            ];\r\n");
      out.write("\r\n");
      out.write("            $( \"#stockName3\" ).autocomplete({\r\n");
      out.write("              source: data\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("        var jsonData = [ \r\n");
      out.write("            {\"value\":\"066570\",\"label\":\"LG전자\",\"price\":\"92,900\"},\r\n");
      out.write("            {\"value\":\"066575\",\"label\":\"LG전자우\",\"price\":\"45,100\"}\r\n");
      out.write("        ];\r\n");
      out.write("\r\n");
      out.write("       $(\"#stockName2\").autocomplete({\r\n");
      out.write("          source: jsonData,\r\n");
      out.write("          select: function( event, ui ) {\r\n");
      out.write("            $(this).val(ui.item.label);\r\n");
      out.write("            $(\"#stockCode2\").val(ui.item.value);\r\n");
      out.write("            $(\"#stockPrice2\").html(ui.item.price);\r\n");
      out.write("            return false;\r\n");
      out.write("          },\r\n");
      out.write("          focus : function(event, ui) {  return false; }     \r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("            \r\n");
      out.write("      var searchRequest = null;\r\n");
      out.write("\r\n");
      out.write("	  /*\r\n");
      out.write("        https://www.sedaily.com/Stock/Quote/JsonSearchData?text=LG전자\r\n");
      out.write("       \r\n");
      out.write("       JSON Data Format\r\n");
      out.write("       { \"Items\": \r\n");
      out.write("        [ {\"Market\":\"1\",\"IndustryCode\":\"013\",\"StockCode\":\"066570\",\"StockName\":\"LG전자\",\"CurrentPrice\":\"92,900\",\"PreGap\":\"400\",\"PreRate\":\"+0.43\",\"Change\":\"2\",\"Initial\":\"E\",\"StockTime\":\"153004\"},\r\n");
      out.write("          {\"Market\":\"1\",\"IndustryCode\":\"013\",\"StockCode\":\"066575\",\"StockName\":\"LG전자우\",\"CurrentPrice\":\"45,100\",\"PreGap\":\"250\",\"PreRate\":\"-0.55\",\"Change\":\"5\",\"Initial\":\"E\",\"StockTime\":\"153030\"}\r\n");
      out.write("        ]\r\n");
      out.write("       }\r\n");
      out.write("       */\r\n");
      out.write("\r\n");
      out.write("      $(\"#stockName\").autocomplete({\r\n");
      out.write("          \r\n");
      out.write("          source: function( request, response ) {\r\n");
      out.write("            \r\n");
      out.write("           // 이전 요청 초기화 \r\n");
      out.write("		   if(searchRequest != null ) searchRequest.abort(); \r\n");
      out.write("           \r\n");
      out.write("           // jquery의 $.ajax 명령\r\n");
      out.write("            searchRequest = $.ajax({\r\n");
      out.write("              url: \"https://www.sedaily.com/Stock/Quote/JsonSearchData\",  \r\n");
      out.write("              type: \"get\", \r\n");
      out.write("              data: { text: $(\"#stockName\").val() },\r\n");
      out.write("              success: function(data)\r\n");
      out.write("              {\r\n");
      out.write("            	  console.log(data);\r\n");
      out.write("                var obj = data[\"Items\"].map(function(v){\r\n");
      out.write("                    return { \r\n");
      out.write("                      label : v.StockName +\"(\" + v.StockCode +\")\", \r\n");
      out.write("                      value : v.StockCode, \r\n");
      out.write("                      price : v.CurrentPrice,\r\n");
      out.write("                      market : (v.Market==1)?\"코스피\":\"코스닥\",\r\n");
      out.write("                      changes : (v.PreRate.indexOf('-')>0)? -v.PreGap:v.PreGap,\r\n");
      out.write("                      changepct : v.PreRate,\r\n");
      out.write("                      stockTime : v.StockTime,\r\n");
      out.write("					  IndustryCode : v.IndustryCode\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("                response(obj);\r\n");
      out.write("              },\r\n");
      out.write("              dataType: \"json\",\r\n");
      out.write("            });\r\n");
      out.write("           \r\n");
      out.write("          },\r\n");
      out.write("          select: function( event, ui ) { \r\n");
      out.write("            // 항목을 선택하면 HTML 페이지에 전달/표시 \r\n");
      out.write("            $(this).val(ui.item.label);\r\n");
      out.write("            $(\"#stockCode\").val(ui.item.value);\r\n");
      out.write("            $(\"#stockPrice\").html(ui.item.price);\r\n");
      out.write("            $(\"#market\").html(ui.item.market);\r\n");
      out.write("            $(\"#changes\").html(ui.item.changes);\r\n");
      out.write("            $(\"#changepct\").html(ui.item.changepct);\r\n");
      out.write("            $(\"#stockTime\").html(ui.item.stockTime);\r\n");
      out.write("\r\n");
      out.write("            return false;\r\n");
      out.write("          },\r\n");
      out.write("          focus : function(event, ui) { \r\n");
      out.write("              return false;\r\n");
      out.write("          },     \r\n");
      out.write("          autoFocus: true, \r\n");
      out.write("          minLength: 2 // 최소 글자수\r\n");
      out.write("        });\r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("    });\r\n");
      out.write("     \r\n");
      out.write("     \r\n");
      out.write("      \r\n");
      out.write("  </script>\r\n");
      out.write("</head>\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("  <div id=\"notice\"></div>\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("   <form id=\"input_form\">\r\n");
      out.write("\r\n");
      out.write("   <h3> 예제 1 - 기본 ( 로컬 데이터 )  LG전자로 입력 </h3>\r\n");
      out.write("    \r\n");
      out.write("    <table width=\"400\" height=\"100%\">\r\n");
      out.write("    <tr>\r\n");
      out.write("      <th > 종목명</th>\r\n");
      out.write("      <td>\r\n");
      out.write("        <input type=\"text\" name=\"stockName2\" id=\"stockName3\" width=\"100%\" value =\"L\"> \r\n");
      out.write("      </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("\r\n");
      out.write("<hr>\r\n");
      out.write("   <h3> 예제 2 - 기본 ( 로컬 데이터 )  LG전자로 입력 </h3>\r\n");
      out.write("    \r\n");
      out.write("    <table width=\"400\" height=\"100%\">\r\n");
      out.write("    <tr>\r\n");
      out.write("      <th > 종목명</th>\r\n");
      out.write("      <td>\r\n");
      out.write("        <input type=\"text\" name=\"stockName2\" id=\"stockName2\" width=\"100%\" value =\"L\"> \r\n");
      out.write("      </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <th>종목코드</th>\r\n");
      out.write("      <td>\r\n");
      out.write("        <input type=\"text\" name=\"stockCode2\" id=\"stockCode2\" value=\"\" size=6 />\r\n");
      out.write("      </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <th>주가정보</th>\r\n");
      out.write("      <td>\r\n");
      out.write("            <div>주가    :<span id =\"stockPrice2\"></span></div>\r\n");
      out.write("      </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("\r\n");
      out.write("<hr>\r\n");
      out.write("    <h3> 예제 3 - 원격 데이터 , 실시간 주가 정보 검색   </h3>\r\n");
      out.write("\r\n");
      out.write("    <table width=\"400\" height=\"100%\">\r\n");
      out.write("    <tr>\r\n");
      out.write("      <th > 종목명</th>\r\n");
      out.write("      <td>\r\n");
      out.write("        <input type=\"text\" name=\"stockName\" id=\"stockName\" width=\"100%\"> \r\n");
      out.write("      </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <th>종목코드</th>\r\n");
      out.write("      <td>\r\n");
      out.write("        <input type=\"text\" name=\"stockCode\" id=\"stockCode\" value=\"\" size=6 />\r\n");
      out.write("      </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <th>주가정보</th>\r\n");
      out.write("      <td>\r\n");
      out.write("            <div>시장:   :<span id =\"market\"></span></div>\r\n");
      out.write("            <div>주가    :<span id =\"stockPrice\"></span></div>\r\n");
      out.write("            <div>전일비 :<span id =\"changes\"></span></div>\r\n");
      out.write("            <div>등락률 :<span id =\"changepct\"></span></div>\r\n");
      out.write("            <div>시간 : <span id =\"stockTime\"></span></div>\r\n");
      out.write("      </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("  </body>\r\n");
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