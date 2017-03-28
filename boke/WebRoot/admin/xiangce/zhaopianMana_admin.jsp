<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<LINK href="<%=path %>/css/css.css" type=text/css rel=stylesheet>
	<script type="text/javascript" src="<%=path %>/js/popup_shuaxin.js"></script>
	<script type="text/javascript">
    function zhaopianDel_admin(id)
    {
         var url="<%=path %>/zhaopianDel.action?id="+id;
         var pop=new Popup({ contentType:1,isReloadOnClose:false,width:240,height:90});
         pop.setContent("contentUrl",url);
         pop.setContent("title","照片删除");
         pop.build();
         pop.show();
    }
	</script>
  </head>
  
  <body>
      <table cellspacing="9" cellpadding="2">
          <tr>
               <c:forEach items="${requestScope.zhaopianList}" var="zhaopian" varStatus="sta">
                  <c:if test="${sta.index%5==0}">
                     </tr><tr>
                  </c:if>
                  <td align="center">
						<img style="border:1px solid #ccc; padding:3px;" src="<%=path %>/${zhaopian.fujian}" width="100" height="120"/>
						<br>
						${zhaopian.title}
						<a href="#" onclick="zhaopianDel_admin(${zhaopian.id })">[删除]</a>
                  </td>
              </c:forEach>
          </tr>
       </table>
  </body>
</html>
