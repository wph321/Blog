<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
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
       function userEditPre()
       {
            var url="<%=path %>/qiantai/gerenzhuye/userEditPre.jsp";
            var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:360});
            pop.setContent("contentUrl",url);
            pop.setContent("title","管理个人资料");
            pop.build();
            pop.show();
       }
       
       function rizhiAdd()
       {
            var url="<%=path %>/qiantai/gerenzhuye/rizhi/rizhiAdd.jsp";
            var pop=new Popup({ contentType:1,isReloadOnClose:false,width:700,height:400});
            pop.setContent("contentUrl",url);
            pop.setContent("title","新日志");
            pop.build();
            pop.show();
       }
       function rizhiDel(id)
       {
            var url="<%=path %>/rizhiDel.action?id="+id;
            var pop=new Popup({ contentType:1,isReloadOnClose:false,width:240,height:90});
            pop.setContent("contentUrl",url);
            pop.setContent("title","删除日志");
            pop.build();
            pop.show();
       }
       
    </script>
    
  </head>
  
  <BODY text=#000000  leftMargin=0 topMargin=0>
	<div class="wrap"> 
		<TABLE  cellSpacing=0 cellPadding=0 width="100%" align=center border=0  background="<%=path %>/img/reservation01.gif">
				<TR height="90">
					<TD align="center" style="color: white">
					    <br/><font size="13px;">${sessionScope.user.userRealname }的BLOG,${sessionScope.user.userRealname }的博客</font> 
					</TD>
				</TR>
		</TABLE>
		
		
		<TABLE id=guide cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
				<TR>
					<TD align="left">
						&nbsp;&nbsp;
				        <a href="<%=path %>/bowenMana.action">博文管理</A> &nbsp;&nbsp;
				        <a href="<%=path %>/xiangceMana.action">相册管理</A> &nbsp;&nbsp;
				        <a href="<%=path %>/rizhiMana.action">日志管理</A> &nbsp;&nbsp;
				        <a href="<%=path %>/haoyouMana.action">好友管理</A> &nbsp;&nbsp;
					</TD>
				</TR>
		</TABLE>

        <TABLE class=MainTable style="MARGIN-TOP: 0px" cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
				<TR>
				    <TD class=Side vAlign=top align=right width="25%">
						 <TABLE width="100%" height="160" border=0 cellPadding=0 cellSpacing=0 class=dragTable>
								<TR>
									<TD class=head>
										<span style="float:left" class="TAG">个人资料</span>
							            <span style="float:right"><a href="#" onclick="userEditPre()">[修改]</a>&nbsp;&nbsp;&nbsp;&nbsp;</span>
									</TD>
								</TR>
								<TR>
									<TD class=middle align="center">
									     <table>
									         <tr>
									            <td align="center">
									                <img src="<%=path %>/${sessionScope.user.fujian }" width="140" height="170">
									            </td>
									         </tr>
									         <tr>
									            <td align="left" style="font-size: 14px;">
									               <br>
									                 昵称：${sessionScope.user.userRealname }<br>
									                 住址：${sessionScope.user.userAddress }<br>
									                 性别：${sessionScope.user.userSex }<br>
									                 访问：${sessionScope.user.fangwenliang }
									            </td>
									         </tr>
									     </table>
									</TD>
								</TR>
						</TABLE>
						<TABLE width="100%" height="160" border=0 cellPadding=0 cellSpacing=0 class=dragTable>
								<TR>
									<TD class=head>
										<SPAN class=TAG>日历表</SPAN>
									</TD>
								</TR>
								<TR>
									<TD class=middle align="center">
									     <jsp:include flush="true" page="/qiantai/rili/rili.jsp"></jsp:include>
									</TD>
								</TR>
						</TABLE>
					</TD>
					<td width="1">&nbsp;</td>
					<TD class=Side vAlign=top align=right width="75%">
						<TABLE class=dragTable cellSpacing=0 cellPadding=0 width="100%" border=0>
								<TR>
									<TD class=head>
										<span style="float:left" class="TAG">日志管理</span>
							            <span style="float:right"><a href="#" onclick="rizhiAdd()">[新日志] </a>&nbsp;&nbsp;&nbsp;&nbsp;</span>
									</TD>
								</TR>
								<TR align="left">
									<TD height="5"></TD>
								</TR>
								<TR align="left" height="620">
									<TD>
									    <c:forEach items="${requestScope.rizhiList}" var="rizhi" varStatus="ss">
											<TABLE cellpadding="12" cellspacing="12">
												<TR>
													<td>
													   <font style="font-size: 17px;font-family: 幼圆">${ss.index+1 }.${rizhi.title }</font>&nbsp;&nbsp;(${rizhi.shijian })
													   &nbsp;&nbsp;&nbsp;<a href="#" onclick="rizhiDel(${rizhi.id })">[删除]</a>
													</td>
												</TR>
												<TR>
													<td><c:out value="${rizhi.content }" escapeXml="false"></c:out></td>
												</TR>
												<tr>
												   <td>
												       <hr style="BORDER-BOTTOM-STYLE: dotted; BORDER-LEFT-STYLE: dotted; BORDER-RIGHT-STYLE: dotted; BORDER-TOP-STYLE: dotted" color=blue size=1 width="500">
												   </td>
												</tr>
											</TABLE>
										</c:forEach>
									</TD>
								</TR>
								<TR align="left">
									<TD height="5"></TD>
								</TR>
						</TABLE>
					</TD>
				</TR>
		</TABLE>
		<TABLE id=footer cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
             <TR>
                  <TD align=middle><DIV align=center>建议使用IE6.0或以上版本浏览 <br>&nbsp;&nbsp;&nbsp;</DIV></TD>
             </TR>
        </TABLE>
    </div>
  </BODY>
</html>
