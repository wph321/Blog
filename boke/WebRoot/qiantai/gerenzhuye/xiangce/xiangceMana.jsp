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
       
       function xiangceAdd()
       {
            var url="<%=path %>/qiantai/gerenzhuye/xiangce/xiangceAdd.jsp";
            var pop=new Popup({ contentType:1,isReloadOnClose:false,width:300,height:200});
            pop.setContent("contentUrl",url);
            pop.setContent("title","相册");
            pop.build();
            pop.show();
       }
       function xiangceDel(id)
       {
            var url="<%=path %>/xiangceDel.action?id="+id;
            var pop=new Popup({ contentType:1,isReloadOnClose:false,width:240,height:90});
            pop.setContent("contentUrl",url);
            pop.setContent("title","相册删除");
            pop.build();
            pop.show();
       }
       function zhaopianAdd(xiangceId)
       {
            var url="<%=path %>/qiantai/gerenzhuye/xiangce/zhaopianAdd.jsp?xiangceId="+xiangceId;
            var pop=new Popup({ contentType:1,isReloadOnClose:false,width:500,height:400});
            pop.setContent("contentUrl",url);
            pop.setContent("title","相册");
            pop.build();
            pop.show();
       }
       
       function zhaopianDel(id)
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
									                <img style="border:1px solid #ccc; padding:3px;" src="<%=path %>/${sessionScope.user.fujian }" width="140" height="170">
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
										<span style="float:left" class="TAG">相册管理</span>
							            <span style="float:right"><a href="#" onclick="xiangceAdd()">[新建相册] </a>&nbsp;&nbsp;&nbsp;&nbsp;</span>
									</TD>
								</TR>
						</TABLE>
					    <c:forEach items="${requestScope.xiangceList}" var="xiangce">
						<TABLE class=dragTable cellSpacing=0 cellPadding=0 width="100%" border=0>
								<TR>
									<TD class=head>
										<span style="float:left">相册：${xiangce.name }</span>
							            <span style="float:right"><a href="#" onclick="zhaopianAdd(${xiangce.id })">[上传图片] </a><a href="#" onclick="xiangceDel(${xiangce.id })">[删除] </a>&nbsp;&nbsp;&nbsp;&nbsp;</span>
									</TD>
								</TR>
								<TR align="left">
									<TD height="5"></TD>
								</TR>
								<TR align="left" height="200">
									<TD>
                                       <table cellspacing="9" cellpadding="2">
								          <tr>
								               <c:forEach items="${xiangce.zhaopianList}" var="zhaopian" varStatus="sta">
								                  <c:if test="${sta.index%4==0}">
								                     </tr><tr>
								                  </c:if>
								                  <td align="center">
														<img style="border:1px solid #ccc; padding:3px;" src="<%=path %>/${zhaopian.fujian}" width="150" height="120"/>
														<br>
														${zhaopian.title}
														<a href="#" onclick="zhaopianDel(${zhaopian.id })">[删除]</a>
								                  </td>
								              </c:forEach>
								          </tr>
								       </table>
									</TD>
								</TR>
								<TR align="left">
									<TD height="5"></TD>
								</TR>
						</TABLE>
						</c:forEach>
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
