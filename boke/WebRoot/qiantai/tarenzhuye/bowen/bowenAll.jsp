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
       function pinglunAll(bowenId)
       {
            var url="<%=path %>/pinglunAll.action?bowenId="+bowenId;
            var pop=new Popup({ contentType:1,isReloadOnClose:false,width:650,height:450});
            pop.setContent("contentUrl",url);
            pop.setContent("title","评论");
            pop.build();
            pop.show();
       }
       
       function pinglunAdd(bowenId)
       {
            var url="<%=path %>/qiantai/tarenzhuye/bowen/pinglunAdd.jsp?bowenId="+bowenId;
            var pop=new Popup({ contentType:1,isReloadOnClose:false,width:700,height:400});
            pop.setContent("contentUrl",url);
            pop.setContent("title","写评论");
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
					    <br/><font size="13px;">${requestScope.user.userRealname }的BLOG,${requestScope.user.userRealname }的博客</font> 
					</TD>
				</TR>
		</TABLE>
		
		
		<TABLE id=guide cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
				<TR>
					<TD align="left">
						&nbsp;&nbsp;
				        <a href="<%=path %>/tarenzhuye.action?userId=${requestScope.user.userId }">博文信息</A> &nbsp;&nbsp;
				        <!-- 博文就是首页。因为博文就在首页上显示 -->
				        <a href="<%=path %>/xiangceAll.action?userId=${requestScope.user.userId }">相册信息</A> &nbsp;&nbsp;
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
							            <span style="float:right">&nbsp;&nbsp;&nbsp;&nbsp;</span>
									</TD>
								</TR>
								<TR>
									<TD class=middle align="center">
									     <table>
									         <tr>
									            <td align="center">
									                <img src="<%=path %>/${requestScope.user.fujian }" width="140" height="170">
									            </td>
									         </tr>
									         <tr>
									            <td align="left" style="font-size: 14px;">
									               <br>
									                 昵称：${requestScope.user.userRealname }<br>
									                 住址：${requestScope.user.userAddress }<br>
									                 性别：${requestScope.user.userSex }<br>
									                 访问：${requestScope.user.fangwenliang }
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
										<span style="float:left" class="TAG">博文</span>
							            <span style="float:right">&nbsp;&nbsp;&nbsp;&nbsp;</span>
									</TD>
								</TR>
								<TR align="left">
									<TD height="5"></TD>
								</TR>
								<TR align="left" height="620">
									<TD>
									    <c:forEach items="${requestScope.bowenList}" var="bowen" varStatus="ss">
											<TABLE cellpadding="12" cellspacing="12">
												<TR>
													<td>
													   <font style="font-size: 17px;font-family: 幼圆">${ss.index+1 }.${bowen.title }</font>&nbsp;&nbsp;(${bowen.shijian })
													</td>
												</TR>
												<TR>
													<td><c:out value="${bowen.content }" escapeXml="false"></c:out></td>
												</TR>
												<tr>
												   <td>
												       <a href="#" onclick="pinglunAll(${bowen.id })">评论(${bowen.pinglunShu })</a>
												       &nbsp;
												       <a href="#" onclick="pinglunAdd(${bowen.id })">写评论</a>
												   </td>
												</tr>
												<tr>
												   <td>
												       <hr style="BORDER-BOTTOM-STYLE: dotted; BORDER-LEFT-STYLE: dotted; BORDER-RIGHT-STYLE: dotted; BORDER-TOP-STYLE: dotted" color=blue size=1 width="100%">
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
